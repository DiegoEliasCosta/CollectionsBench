package de.heidelberg.pvs.container_bench.benchmarks.misc;

import java.io.IOException;
import java.util.Arrays;
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

import de.heidelberg.pvs.container_bench.generators.ElementGenerator;
import de.heidelberg.pvs.container_bench.generators.GeneratorFactory;
import de.heidelberg.pvs.container_bench.generators.PayloadType;

@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Timeout(time = 20, timeUnit = TimeUnit.SECONDS)
@Warmup(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 40, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(2)
@State(Scope.Thread)
public class ArrayCopyStrategies {
	
	/**
	 * From 100 - 1M
	 */
	@Param({ "100", "1000", "10000", "100000", "1000000" })
	public int size;
	
	String[] src;
	String[] dest;

	private ElementGenerator<String> generator;
	
	@SuppressWarnings("unchecked")
	@Setup
	public void setup() throws IOException {
		generator = (ElementGenerator<String>) GeneratorFactory.buildRandomGenerator(PayloadType.STRING_DICTIONARY);
		generator.init(size, 42);
		
		src = new String[size];
		src = generator.generateArray(size);
	}
	
	@Benchmark
	public void systemCopyBenchmark(Blackhole bh) {
		dest = new String[size];
		System.arraycopy(src, 0, dest, 0, size);
	}
	
	@Benchmark
	public void arraysCopy(Blackhole bh) {
		dest = Arrays.copyOf(src, size);
	}

}
