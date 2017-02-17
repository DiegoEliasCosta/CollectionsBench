package de.heidelberg.pvs.container_bench.preliminary_tests;

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

import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 7, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(2)
@State(Scope.Benchmark)

public class String_Memory_Test {
	
	Blackhole blackhole;
	StringRandomGenerator generator = new StringRandomGenerator();

	@Param({ "467505" })
	public int seed;
	
	@Setup 
	public void setup(Blackhole blackhole) {
		this.blackhole = blackhole;
		generator.setSeed(seed);	
	}
	
	@Benchmark
	public void allocateString() {
		blackhole.consume(generator.generate());
	}
}
