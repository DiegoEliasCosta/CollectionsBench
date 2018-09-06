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

import de.heidelberg.pvs.container_bench.generators.Wordlist;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Timeout(time = 1, timeUnit = TimeUnit.MINUTES)
@Warmup(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 40, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(2)
@Threads(1)
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
		public long totalsize;
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

	@Setup(Level.Iteration)
	public void setupState() {
		map = makeMap();
	}

	/**
	 * Class to benchmark a single adapter.
	 * 
	 * @param data
	 *            Data to process
	 */
	@Benchmark
	public void wordcount(Data data) throws InterruptedException {
		List<String> words = data.words;
		for (int i = 0, size = words.size(); i < size; i++) {
			String word = words.get(i);
			count(map, word);
			// bh.consume(word); // try to prevent loop unrolling
			if (Thread.interrupted()) {
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
	public void memory(Memory memory) {
		memory.totalsize = map != null ? GraphLayout.parseInstance(map).totalSize() : 0;
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
}
