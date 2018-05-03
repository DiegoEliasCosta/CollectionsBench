package de.heidelberg.pvs.container_bench.wordcount;

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

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Timeout(time = 1, timeUnit = TimeUnit.MINUTES)
@Warmup(iterations = 2, time = 5, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 11, time = 15, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@Threads(1)
@State(Scope.Benchmark)
public abstract class AbstractWordcountBenchmark<T> {
	/** Number of words to load from the file. Must be large enough for your measurement time! */
	public int sizelimit = 100_000;

	/** -1: no random shuffling */
	@Param({ "-1" })
	public int seed = -1;

	/** File name of our input data. */
	public static final String FILENAME = "enwiki-100m.txt.gz";

	/** Word list */
	protected List<String> words;

	@State(Scope.Thread)
	public static class BenchState<T> {
		T map;

		int pos;
	}

	@Setup(Level.Trial)
	public void setup() throws IOException {
		// Load the Wikipedia word data.
		try (InputStream is = ClassLoader.getSystemResourceAsStream(FILENAME);
				InputStream gi = new GZIPInputStream(is);
				Reader r = new InputStreamReader(gi);
				BufferedReader reader = new BufferedReader(r)) {
			final int stop = seed == -1 ? sizelimit : (sizelimit << 1);
			words = new ArrayList<>(stop);
			String line;
			Matcher m = Pattern.compile("[\\w–-]+", Pattern.UNICODE_CHARACTER_CLASS).matcher("");
			while ((line = reader.readLine()) != null && words.size() < stop) {
				m.reset(line);
				while (m.find()) {
					words.add(m.group());
				}
			}
			if (seed != -1) {
				Collections.shuffle(words, new Random(seed));
			}
			words.subList(sizelimit, words.size()).clear(); // Truncate
		}
	}

	@Setup(Level.Trial)
	public void setupState(BenchState<T> state) {
		state.map = makeMap();
		state.pos = 0;
	}

	/**
	 * Class to benchmark a single adapter.
	 * 
	 * @param state
	 *            State
	 * @return collection size
	 */
	@Benchmark
	public int wordcount(BenchState<T> state) {
		count(state.map, words.get(state.pos++));
		return size(state.map); // prevent elimination
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
	abstract protected void count(T map, Object object);

	/**
	 * Size of data structure.
	 *
	 * @param map
	 *            data
	 * @return Size
	 */
	abstract protected int size(T map);
}
