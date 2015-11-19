package de.heidelberg.pvs.container_bench.abstracts;

import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.infra.Blackhole;


public abstract class AbstractListTest extends AbstractBenchmarkTest { 
	
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
