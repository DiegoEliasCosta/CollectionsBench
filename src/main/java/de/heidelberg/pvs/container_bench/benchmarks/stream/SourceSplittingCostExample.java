package de.heidelberg.pvs.container_bench.benchmarks.stream;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.openjdk.jmh.annotations.Benchmark;
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
import org.openjdk.jmh.infra.Blackhole;

/**
 * Example taken from the talk "Understanding Parallel Stream Performance in Java SE 8"
 * https://www.infoq.com/presentations/parallel-java-se-8
 * 
 * @author diego
 *
 */
@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Timeout(time = 20, timeUnit = TimeUnit.SECONDS)
@Warmup(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 40, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(2)
@State(Scope.Thread)
public class SourceSplittingCostExample {

	@Param({"10000", "100000"})
	public int n;
	
	/**
	 * This benchmark use iterative generator and should run considerably slower.
	 * @param bh
	 */
	@Benchmark
	public void sumWithIterativeGenerator(Blackhole bh) {
		bh.consume(IntStream.iterate(0, i -> i + 1).limit(n).sum());
	}

	/**
	 * This benchmark use stateless generator and should yield substantially 
	 * faster results
	 */
	@Benchmark
	public void sumWithStatelessGenerator(Blackhole bh) {
		bh.consume(IntStream.range(0, n).sum());
	}
	
}
