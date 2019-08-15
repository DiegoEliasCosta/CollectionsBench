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

@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Timeout(time = 20, timeUnit = TimeUnit.SECONDS)
@Warmup(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 40, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(2)
@State(Scope.Thread)
public class PrimesCount {


	@Param({"100","1000", "10000", "100000", "1000000"})
	int max;
	
	@Benchmark
	public long parallelCountPrimes() {
		return IntStream.range(1, max).parallel().filter(this::isPrime).count();
	}
	
	@Benchmark
	public long sequentialCountPrimes() {
		return IntStream.range(1, max).filter(this::isPrime).count();
	}

	private boolean isPrime(int n) {
		return n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(divisor -> n % divisor == 0);
	}

}
