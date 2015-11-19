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

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Threads(1)
@Fork(2)
@State(Scope.Benchmark)
public abstract class AbstractListTest {

	@Param({ "10000" })
	public int size;

	@Param({ "0" })
	public int seed;
	
	@Setup
	abstract public void setup(Blackhole blackhole);

	/**
	 * Benchmark GetAll
	 * 
	 * This benchmark measure the time spent in traversing the list. <br>
	 * <code> 
	 * <pre>
	 * for(;;) 
	 *     list.get(i) 
	 * </pre> 
	 * </code> 
	 */
	abstract public void getAll();

	/**
	 * Benchmark GetAt
	 * 
	 * This benchmark measure the time spent in getting an element in a
	 * <b>random</b> position of the list <br>
	 * <br>
	 * <code>
	 * index = random() <br>
	 * list.get(index); <br>
	 * </code>
	 * 
	 */
	abstract public void getAtIndex();

	/**
	 * Benchmark RemoveAt
	 * 
	 * This benchmark measure the time spent in removing a <b>random</b> element
	 * of the list. <br>
	 * <br>
	 * <code>
	 * index = random() <br>
	 * list.remove(index)
	 * </code>
	 */
	abstract public void removeAtIndex();

	/**
	 * Benchmark Clear
	 * 
	 * This benchmark measure the time spent in clearing the list <br>
	 * <br>
	 * <code>
	 * list.clear()
	 * </code>
	 * 
	 */
	abstract public void clear();

	/**
	 * Benchmark Contains
	 * 
	 * This benchmark measure the time spent executing a contain to a <b>random</b>
	 * element in the list
	 * <br> <br>
	 * <code>
	 * randomElement = random()
	 * list.contains(randomElement)
	 * </code>
	 * 
	 */
	abstract public void contains();

	/**
	 * Benchmark Instantiate
	 * 
	 * This benchmark measure the time spent by creating a new list
	 * <br><br>
	 * <code>
	 * list = new List()
	 * </code>
	 */
	abstract public void instantiate();

	/**
	 * Benchmark AddAll
	 * 
	 * This benchmark measure the time spent by adding <b>random</b> elements into 
	 * the list, until it reaches its specified size
	 * <code> 
	 * <pre>
	 * for(;;) 
	 *     list.add(random())
	 * </code>
	 * 
	 */
	abstract public void addAll();
	
	/**
	 * Benchmark Copy
	 * 
	 * This benchmark measure the time spent by copying the entire list to a new instance
	 * <code>
	 * <pre>
	 * newlist = copy(oldList)
	 * </pre>
	 * </code>
	 * 
	 */
	abstract public void copyList();

}
