package de.heidelberg.pvs.container_bench.benchmarks.stackoverflow;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Timeout;
import org.openjdk.jmh.annotations.Warmup;

/**
 * Class to uniform the control parameters of stack-overflow benchmark
 * 
 * @author diego.costa
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
public class StackOverflowQuestionsBench {

}
