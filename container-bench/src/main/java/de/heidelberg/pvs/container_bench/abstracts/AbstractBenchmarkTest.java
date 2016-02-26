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
import org.openjdk.jmh.annotations.Timeout;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
@Warmup(iterations = 7, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 15, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(1)
@State(Scope.Benchmark)
public abstract class AbstractBenchmarkTest {
	
	/**
	 * From 10K - 100M
	 */
	@Param({ "1000", "10000", "100000", "1000000", "10000000" })
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
	 * Setup method of the benchmark
	 */
	public abstract void randomnessSetup();
	
	public abstract void testSetup();
	

	@Setup
	public void initializeSetup(Blackhole blackhole) {
		this.blackhole = blackhole;
		// Initialize the seed 
		this.randomnessSetup();
		// Test Setup
		this.testSetup();
	}

}
