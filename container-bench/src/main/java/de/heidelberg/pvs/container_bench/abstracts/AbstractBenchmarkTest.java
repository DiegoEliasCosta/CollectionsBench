package de.heidelberg.pvs.container_bench.abstracts;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import de.heidelberg.pvs.container_bench.utils.JDKRandomGenerator;
import de.heidelberg.pvs.container_bench.utils.RandomGenerator;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(2)
@State(Scope.Benchmark)
public abstract class AbstractBenchmarkTest {
	
	/**
	 * From 10K - 100M
	 */
	@Param({ "1000", "10000","100000", "1000000", "10000000" , "100000000"})
	public int size;

	/**
	 * Random seed generated using https://www.random.org/
	 * Number between 1 - 1M
	 */
	@Param({ "467505" })
	public int seed;
	
	/**
	 * Blackhole object responsible for consuming any return from our tested methods 
	 */
	protected Blackhole blackhole;
	
	/**
	 * Implementation of our Randomness 
	 */
	protected RandomGenerator randomGenerator = new JDKRandomGenerator();

	
	/**
	 * Setup method of the benchmark
	 */
	public abstract void setup();
	
	@Setup
	public void initializeSetup(Blackhole blackhole) {
		this.blackhole = blackhole;
		// Initialize the seed 
		randomGenerator.initializeSeed(seed);
		this.setup();
	}

}
