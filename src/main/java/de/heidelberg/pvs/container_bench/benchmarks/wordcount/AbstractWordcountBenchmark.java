package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.AuxCounters;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.CompilerControl;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Timeout;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.info.GraphPathRecord;
import org.openjdk.jol.vm.VM;

import de.heidelberg.pvs.container_bench.generators.Wordlist;


@BenchmarkMode(Mode.SampleTime)
// We need to use a fake single-shot to get auxiliary measurements.
// If you only want to measure time, single-shot mode is okay, too.
@Warmup(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 40, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(2)
@Threads(1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Timeout(time = 10, timeUnit = TimeUnit.SECONDS)
@State(Scope.Thread)
public abstract class AbstractWordcountBenchmark<T> {
	/**
	 * Number of words to load from the file.
	 */
	@Param({ "100", "1000", "10000", "100000", "1000000" })
	public int size;

	/** -1: no random shuffling */
	@Param({ "-1" })
	public int seed = -1;

	/** Do memory analysis */
	protected boolean doMemory = System.getProperty("doMemory", "false").equals("true");

	/** Fake parameter, for uniform output */
	@Param
	public WorkloadEnum workload;

	public static enum WorkloadEnum {
		WORDCOUNT
	};

	Blackhole bh;

	T map;

	@AuxCounters(AuxCounters.Type.EVENTS)
	@State(Scope.Thread)
	public static class Memory {
		/** Memory size of the collection */
		public long totalmemory;
		/** Sum of the array sizes */
		public long tablesizesum;
		/** Maximum size of an array used */
		public long tablesizemax;
		/** Number of stored entries */
		public long numentries;
	}

	@State(Scope.Benchmark)
	public static class Data {
		/** Word list */
		protected List<String> words;
	}

	@Setup(Level.Trial)
	public void setupData(Blackhole b, Data data) throws IOException {
		bh = b;
		data.words = Wordlist.loadWords(size, seed);
	}

	/**
	 * Class to benchmark a single adapter.
	 * 
	 * @param data
	 *            Data to process
	 */
	@Benchmark
	public void wordcount(Data data) throws InterruptedException {
		map = makeMap();
		List<String> words = data.words;
		for (int i = 0, size = words.size(); i < size; i++) {
			String word = words.get(i);
			count(map, word);
			// bh.consume(word); // try to prevent loop unrolling
			if (Thread.interrupted()) {
				doMemory = false;
				throw new InterruptedException();
			}
		}
		bh.consume(map); // prevent elimination
	}

	/**
	 * Memory measurement at teardown.
	 *
	 * @param memory
	 *            Memory counter
	 */
	@TearDown(Level.Iteration)
	public final void memory(Memory memory) {
		if (!doMemory || map == null)
			return; // Avoid costly
		measureMemory(map, memory);
	}

	protected void measureMemory(T map, Memory memory) {
		memory.numentries = size(map);
		GraphLayout layout = GraphLayout.parseInstance(map);
		memory.totalmemory = layout.totalSize();
		long emptyarray = VM.current().sizeOf(new int[0]);
		for (Long addr : layout.addresses()) {
			if (Thread.interrupted()) {
				memory.tablesizemax = memory.tablesizesum = -1;
				return;
			}
			GraphPathRecord record = layout.record(addr);
			if (record.klass().isArray()) {
				Class<?> type = record.klass().getComponentType();
				if (type == char.class || type == byte.class) { // Probably a string.
					continue;
				}
				final long s = VM.current().sizeOfField(type.toString());
				final long numentries = (record.size() - emptyarray) / s;
				memory.tablesizesum += numentries;
				memory.tablesizemax = Math.max(memory.tablesizemax, numentries);
			}
		}
	}

	/**
	 * Provide the map to use.
	 *
	 * @return Map
	 */
	abstract protected T makeMap();

	/**
	 * Count a single object
	 *
	 * @param map
	 *            data
	 * @param object
	 *            Object to count.
	 */
	@CompilerControl(CompilerControl.Mode.DONT_INLINE)
	abstract protected void count(T map, String object);

	/**
	 * Collection size. To detect usage errors.
	 *
	 * @param map
	 *            Map
	 * @return size of the collection
	 */
	abstract protected int size(T map);
}
