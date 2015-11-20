package de.heidelberg.pvs.container_bench.utils;

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
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(1)
@State(Scope.Benchmark)
public class RandomGeneratorBechmarkTest {

	private RandomGenerator jdkGenerator = new JDKRandomGenerator();

	private RandomGenerator apacheGenerator = new ApacheRandomGenerator();

	@Param({ "0", "42", "976431" })
	int seed;

	@Param({ "10", "1000000" })
	int size;

	@Param({ "1000" })
	int range;

	private Blackhole bh;

	@Setup
	public void setup(Blackhole bh) {
		this.bh = bh;
		jdkGenerator.initializeSeed(seed);
		apacheGenerator.initializeSeed(seed);
	}

	@Benchmark
	public void jdkGenerateIntegers() {
		bh.consume(this.jdkGenerator.generateIntegers(seed, size));
	}

	@Benchmark
	public void jdkGenerateIntegersInRange() {
		bh.consume(this.jdkGenerator.generateIntegersInRange(seed, size, range));
	}

	@Benchmark
	public void apacheGenerateIntegers() {
		bh.consume(this.apacheGenerator.generateIntegers(seed, size));
	}

	@Benchmark
	public void apacheGenerateIntegersInRange() {
		bh.consume(this.apacheGenerator.generateIntegersInRange(seed, size, range));
	}

}
