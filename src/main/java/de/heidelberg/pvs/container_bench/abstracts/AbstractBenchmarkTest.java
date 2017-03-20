package de.heidelberg.pvs.container_bench.abstracts;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
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
import org.openjdk.jol.info.GraphLayout;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 30, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(2)
@State(Scope.Benchmark)
public abstract class AbstractBenchmarkTest {

	/**
	 * From 10K - 100M
	 */
	@Param({ "100", "1000", "10000", "100000", "1000000" })
	public int size;

	/**
	 * Output file for the memory check
	 */
	@Param({ "memory-footprint.log" })
	public String memoryFootprintFile;

	/**
	 * Random seed generated using https://www.random.org/ Number between 1 - 1M
	 */
	@Param({ "467505" })
	public int seed;

	/**
	 * Blackhole object responsible for consuming any return from our tested
	 * methods
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

	protected abstract Object getFullCollection();

	@Benchmark
	@BenchmarkMode(Mode.SingleShotTime)
	public void reportCollectionFootprint() throws IOException {

		Object fullCollection = getFullCollection();

		// Write to the file
		String footprint = String.format("%s\n%s", fullCollection.getClass().getName(),
				GraphLayout.parseInstance(fullCollection).toFootprint());
		
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(new FileWriter(this.memoryFootprintFile, true));
			printWriter.write(footprint);
		} finally {
			if(printWriter != null) {
				printWriter.close();
			}
		}

	}

}
