package de.heidelberg.pvs.container_bench.wordlist.sets;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
public abstract class AbstractWordSetBenchmark<T> {
	/** Workload to process */
	@Param
	public Workload workload;

	/**
	 * Number of words to load from the file.
	 *
	 * Named zz to have this sort last.
	 */
	@Param({ "100000" })
	public int zzsize = 100_000;

	/** -1: no random shuffling */
	@Param({ "-1" })
	public int seed = -1;

	Blackhole bh;

	T set;

	/** Word list */
	protected List<String> words;

	@Setup(Level.Iteration)
	public void setup(Blackhole b) throws IOException, InterruptedException {
		bh = b;
		words = words != null ? words : Wordlist.loadWords(b, zzsize, seed);
		workload.init(this);
	}

	@Benchmark
	public void bench() throws InterruptedException {
		workload.run(this);
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
	 * @param object
	 *            Object to add.
	 */
	@CompilerControl(CompilerControl.Mode.DONT_INLINE)
	abstract protected void add(String object);

	/**
	 * Test for containment.
	 *
	 * @param object
	 *            Object to check.
	 */
	@CompilerControl(CompilerControl.Mode.DONT_INLINE)
	abstract protected boolean contains(String object);

	/**
	 * Remove a single object
	 *
	 * @param object
	 *            Object to remove.
	 */
	@CompilerControl(CompilerControl.Mode.DONT_INLINE)
	abstract protected void remove(String object);

	public enum Workload {
		ADD {
			@Override
			public <T> void run(AbstractWordSetBenchmark<T> self) throws InterruptedException {
				List<String> words = self.words;
				for (int i = 0, size = words.size(); i < size; i++) {
					String word = words.get(i);
					self.add(word);
					if (Thread.interrupted()) {
						throw new InterruptedException();
					}
				}
			}
		}, //
		REMOVE {
			@Override
			public <T> void run(AbstractWordSetBenchmark<T> self) throws InterruptedException {
				List<String> words = self.words;
				for (int i = 0, size = words.size(); i < size; i++) {
					String word = words.get(i);
					self.remove(word);
					if (Thread.interrupted()) {
						throw new InterruptedException();
					}
				}
			}

			@Override
			public <T> void init(AbstractWordSetBenchmark<T> self) throws InterruptedException {
				List<String> words = self.words;
				self.set = self.makeSet();
				for (int i = 0, size = words.size(); i < size; i++) {
					self.add(words.get(i));
					if ((i & 0xFF) == 0 && Thread.interrupted()) {
						throw new InterruptedException();
					}
				}
			}
		}, //
		CONTAINS {
			@Override
			public <T> void run(AbstractWordSetBenchmark<T> self) throws InterruptedException {
				List<String> words = self.words;
				int found = 0;
				for (int i = 0, size = words.size(); i < size; i++) {
					String word = words.get(i);
					if (self.contains(word)) {
						++found;
					}
					if (Thread.interrupted()) {
						throw new InterruptedException();
					}
				}
				self.bh.consume(found); // Prevent elimination
			}

			@Override
			public <T> void init(AbstractWordSetBenchmark<T> self) throws InterruptedException {
				List<String> words = self.words;
				self.set = self.makeSet();
				for (int i = 0, size = words.size(); i < size; i++) {
					self.add(words.get(i));
					if ((i & 0xFF) == 0 && Thread.interrupted()) {
						throw new InterruptedException();
					}
					++i; // Skip every other word for the contains benchmark.
				}
			}
		}, //
		ADD_OR_REMOVE {
			@Override
			public <T> void run(AbstractWordSetBenchmark<T> self) throws InterruptedException {
				List<String> words = self.words;
				for (int i = 0, size = words.size(); i < size;) {
					{
						String word = words.get(i++);
						self.add(word);
					}
					if (i >= size) {
						break;
					}
					{
						String word = words.get(i++);
						self.remove(word);
					}
					if (Thread.interrupted()) {
						throw new InterruptedException();
					}
				}
			}
		}, //
		ADD_THEN_REMOVE {
			@Override
			public <T> void run(AbstractWordSetBenchmark<T> self) throws InterruptedException {
				List<String> words = self.words;
				for (int i = 0, size = words.size(); i < size; i++) {
					String word = words.get(i);
					self.add(word);
					if (Thread.interrupted()) {
						throw new InterruptedException();
					}
				}
				for (int i = 0, size = words.size(); i < size; i++) {
					String word = words.get(i);
					self.remove(word);
					if (Thread.interrupted()) {
						throw new InterruptedException();
					}
				}
			}
		}, //
		REMOVE_THEN_ADD {
			@Override
			public <T> void run(AbstractWordSetBenchmark<T> self) throws InterruptedException {
				List<String> words = self.words;
				for (int i = 0, size = words.size(); i < size; i++) {
					String word = words.get(i);
					self.remove(word);
					if (Thread.interrupted()) {
						throw new InterruptedException();
					}
				}
				for (int i = 0, size = words.size(); i < size; i++) {
					String word = words.get(i);
					self.add(word);
					if (Thread.interrupted()) {
						throw new InterruptedException();
					}
				}
			}

			@Override
			public <T> void init(AbstractWordSetBenchmark<T> self) throws InterruptedException {
				List<String> words = self.words;
				self.set = self.makeSet();
				for (int i = 0, size = words.size(); i < size; i++) {
					self.add(words.get(i));
					if ((i & 0xFF) == 0 && Thread.interrupted()) {
						throw new InterruptedException();
					}
				}
			}
		}, //
		;

		abstract public <T> void run(AbstractWordSetBenchmark<T> self) throws InterruptedException;

		public <T> void init(AbstractWordSetBenchmark<T> self) throws InterruptedException {
			self.set = self.makeSet();
		}
	}
}
