package de.heidelberg.pvs.container_bench.wordaddremove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

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

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
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
	public int sizelimit = 100_000;

	/** -1: no random shuffling */
	@Param({ "-1" })
	public int seed = -1;

	/** File name of our input data. */
	public static final String FILENAME = "enwiki-100m.txt.gz";

	Blackhole bh;

	T set;

	int pos;

	@State(Scope.Benchmark)
	public static class Data {
		/** Word list */
		protected List<String> words;
	}

	@Setup(Level.Trial)
	public void setupData(Blackhole b, Data data) throws IOException {
		bh = b;
		// Load the Wikipedia word data.
		try (InputStream is = ClassLoader.getSystemResourceAsStream(FILENAME);
				InputStream gi = new GZIPInputStream(is);
				Reader r = new InputStreamReader(gi);
				BufferedReader reader = new BufferedReader(r)) {
			final int stop = seed == -1 ? sizelimit : (sizelimit << 1);
			List<String> words = data.words = new ArrayList<>(stop);
			String line;
			Matcher m = Pattern.compile("[\\w–-]+", Pattern.UNICODE_CHARACTER_CLASS).matcher("");
			while ((line = reader.readLine()) != null && words.size() < stop) {
				m.reset(line);
				while (m.find()) {
					String word = m.group();
					b.consume(word.hashCode()); // Precompute hashcode
					words.add(word);
				}
			}
			if (seed != -1) {
				Collections.shuffle(words, new Random(seed));
			}
			words.subList(sizelimit, words.size()).clear(); // Truncate
		}
	}

	@Setup(Level.Iteration)
	public void setupState() {
		set = makeSet();
		pos = 0;
	}

	/**
	 * Class to benchmark a single adapter.
	 * 
	 * @param data
	 *            Data to process
	 */
	@Benchmark
	public void addRemove(Data data) {
		if ((pos & 1) == 0) {
			add(set, data.words.get(pos));
		} else {
			remove(set, data.words.get(pos));
		}
		++pos;
		pos = pos == data.words.size() ? 0 : pos;
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
