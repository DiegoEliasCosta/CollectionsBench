package de.heidelberg.pvs.container_bench.benchmarks.intsets;

import java.io.IOException;
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

import de.heidelberg.pvs.container_bench.generators.Wordlist;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Timeout(time = 1, timeUnit = TimeUnit.MINUTES)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 11, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@Threads(1)
@State(Scope.Thread)
public abstract class AbstractIntSetBenchmark<T> {
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

	/** Mask, to increase the number of collisions - make a parameter? */
	public int mask = 0xFFFFFFFF;

	Blackhole bh;

	T set;

	/** Word list */
	protected int[] words;

	@Setup(Level.Iteration)
	public void setup(Blackhole b) throws IOException, InterruptedException {
		bh = b;
		words = words != null ? words : Wordlist.loadInts(zzsize, seed, mask);
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
	abstract protected void add(int object);

	/**
	 * Test for containment.
	 *
	 * @param object
	 *            Object to check.
	 */
	@CompilerControl(CompilerControl.Mode.DONT_INLINE)
	abstract protected boolean contains(int object);

	/**
	 * Remove a single object
	 *
	 * @param object
	 *            Object to remove.
	 */
	@CompilerControl(CompilerControl.Mode.DONT_INLINE)
	abstract protected void remove(int object);

	public enum Workload {
		ADD {
			@Override
			public <T> void run(AbstractIntSetBenchmark<T> self) throws InterruptedException {
				int[] words = self.words;
				for (int i = 0, size = words.length; i < size && failIfInterrupted(); i++) {
					self.add(words[i]);
				}
			}
		}, //
		REMOVE {
			@Override
			public <T> void run(AbstractIntSetBenchmark<T> self) throws InterruptedException {
				int[] words = self.words;
				for (int i = 0, size = words.length; i < size && failIfInterrupted(); i++) {
					self.remove(words[i]);
				}
			}

			@Override
			public <T> void init(AbstractIntSetBenchmark<T> self) throws InterruptedException {
				int[] words = self.words;
				self.set = self.makeSet();
				for (int i = 0, size = words.length; i < size && failIfInterrupted(); i++) {
					self.add(words[i]);
				}
			}
		}, //
		CONTAINS {
			@Override
			public <T> void run(AbstractIntSetBenchmark<T> self) throws InterruptedException {
				int[] words = self.words;
				int found = 0;
				for (int i = 0, size = words.length; i < size && failIfInterrupted(); i++) {
					if (self.contains(words[i])) {
						++found;
					}
				}
				self.bh.consume(found); // Prevent elimination
			}

			@Override
			public <T> void init(AbstractIntSetBenchmark<T> self) throws InterruptedException {
				int[] words = self.words;
				self.set = self.makeSet();
				for (int i = 0, size = words.length; i < size && failIfInterrupted(); i++) {
					self.add(words[i]);
					++i; // Skip every other word for the contains benchmark.
				}
			}
		}, //
		ADD_OR_REMOVE {
			@Override
			public <T> void run(AbstractIntSetBenchmark<T> self) throws InterruptedException {
				int[] words = self.words;
				for (int i = 0, size = words.length; i < size && failIfInterrupted();) {
					self.add(words[i++]);
					if (i >= size) {
						break;
					}
					self.remove(words[i++]);
				}
			}
		}, //
		ADD_THEN_REMOVE {
			@Override
			public <T> void run(AbstractIntSetBenchmark<T> self) throws InterruptedException {
				int[] words = self.words;
				for (int i = 0, size = words.length; i < size && failIfInterrupted(); i++) {
					self.add(words[i]);
				}
				for (int i = 0, size = words.length; i < size && failIfInterrupted(); i++) {
					self.remove(words[i]);
				}
			}
		}, //
		REMOVE_THEN_ADD {
			@Override
			public <T> void run(AbstractIntSetBenchmark<T> self) throws InterruptedException {
				int[] words = self.words;
				for (int i = 0, size = words.length; i < size && failIfInterrupted(); i++) {
					self.remove(words[i]);
				}
				for (int i = 0, size = words.length; i < size && failIfInterrupted(); i++) {
					self.add(words[i]);
				}
			}

			@Override
			public <T> void init(AbstractIntSetBenchmark<T> self) throws InterruptedException {
				int[] words = self.words;
				self.set = self.makeSet();
				for (int i = 0, size = words.length; i < size && failIfInterrupted(); i++) {
					self.add(words[i]);
				}
			}
		}, //
		;

		public <T> void init(AbstractIntSetBenchmark<T> self) throws InterruptedException {
			self.set = self.makeSet();
		}

		abstract public <T> void run(AbstractIntSetBenchmark<T> self) throws InterruptedException;

		//
		;

		private static boolean failIfInterrupted() throws InterruptedException {
			if (Thread.interrupted()) {
				throw new InterruptedException();
			}
			return true;
		}
	}
}
