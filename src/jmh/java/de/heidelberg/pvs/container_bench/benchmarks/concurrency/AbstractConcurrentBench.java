package de.heidelberg.pvs.container_bench.benchmarks.concurrency;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Timeout;
import org.openjdk.jmh.annotations.Warmup;

@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Timeout(time = 1, timeUnit = TimeUnit.MINUTES)
@Warmup(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 40, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(2)
@Threads(1)
@State(Scope.Benchmark)
public class AbstractConcurrentBench {
	
	@Param({ "100", "1000", "10000", "100000", "1000000" })
	protected int size;

	@Param({ "42" })
	protected int seed;

}
