package de.heidelberg.pvs.container_bench.wordlist.sets;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Timeout;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import de.heidelberg.pvs.container_bench.wordlist.Wordlist;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Timeout(time = 1, timeUnit = TimeUnit.MINUTES)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 11, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@Threads(1)
@State(Scope.Thread)
public abstract class AbstractWordAddRemoveBenchmark<T> {
	/**
	 * Number of words to load from the file. Must be large enough for your
	 * measurement time!
	 */
	@Param({ "100000" })
	public int size = 100_000;

	/** -1: no random shuffling */
	@Param({ "-1" })
	public int seed = -1;

	/** File name of our input data. */
	public static final String FILENAME = "enwiki-100m.txt.gz";

	Blackhole bh;

	T set;

	@State(Scope.Benchmark)
	public static class Data {
		/** Word list */
		protected List<String> words;
	}

	@Setup(Level.Trial)
	public void setupData(Blackhole b, Data data) throws IOException {
		bh = b;
		data.words = Wordlist.loadWords(b, size, seed);
	}

	@Setup(Level.Iteration)
	public void setupState() {
		set = makeSet();
	}

	/**
	 * Class to benchmark a single adapter.
	 * 
	 * @param data
	 *            Data to process
	 */
	@Benchmark
	public void addRemove(Data data) throws InterruptedException {
		List<String> words = data.words;
		for (int i = 0; i < size; i++) {
			{
				String word = words.get(i);
				add(set, word);
				bh.consume(word); // try to prevent loop unrolling
			}
			if (++i >= size) {
				break;
			}
			{
				String word = words.get(i);
				remove(set, word);
				bh.consume(word); // try to prevent loop unrolling
			}
			if (Thread.interrupted()) {
				throw new InterruptedException();
			}
		}
		bh.consume(set); // prevent elimination
	}

	/**
	 * Class to benchmark a single adapter.
	 * 
	 * @param data
	 *            Data to process
	 */
	@Benchmark
	public void add(Data data) throws InterruptedException {
		List<String> words = data.words;
		for (int i = 0; i < size; i++) {
			String word = words.get(i);
			add(set, word);
			bh.consume(word); // try to prevent loop unrolling
			if (Thread.interrupted()) {
				throw new InterruptedException();
			}
		}
		bh.consume(set); // prevent elimination
	}

	/**
	 * Provide the set to use.
	 *
	 * @return Set
	 */
	abstract protected T makeSet();

	/**
	 * Add a single object
	 *
	 * @param map
	 *            data
	 * @param object
	 *            Object to add.
	 */
	abstract protected void add(T map, String object);

	/**
	 * Remove a single object
	 *
	 * @param map
	 *            data
	 * @param object
	 *            Object to remove.
	 */
	abstract protected void remove(T map, String object);
}
