package de.heidelberg.pvs.container_bench.abstracts;

import org.openjdk.jmh.annotations.Param;

public abstract class AbstractMapTest extends AbstractBenchmarkTest {

	@Param({ "10", "100", "1000", "10000" })
	public int rangeOfKeys;
	
	/**
	 * Benchmark PutAll
	 * 
	 * This benchmark measure the time spent at putting a set of elements into
	 * an empty map <code>
	 * <pre>
	 * for(;;)
	 *   element = random()
	 *   map.put(element)
	 * </pre>
	 * </code>
	 * 
	 */
	abstract public void putAll();

	/**
	 * Benchmark GetElement
	 * 
	 * This benchmark measure the time spent by getting a <b>random</b> element
	 * from the map <code><pre>
	 * element = random(range)
	 * map.get(element)
	 * </pre></code>
	 * 
	 */
	abstract public void getElement();

	/**
	 * Benchmark Contains
	 * 
	 * This benchmark measure the time spent by checking whether the map
	 * contains a <b>random</b> element (50% of chance) <code>
	 * <pre>
	 * element = random(1, 2*range) // 50% of chance since elements is is the range
	 * map.contains(element) 
	 * </pre>
	 * </code>
	 * 
	 */
	abstract public void containsElement();

	/**
	 * Benchmark Remove
	 * 
	 * This benchmark measure the time spent by removing an existing element
	 * from the map
	 * 
	 * <code>
	 * <pre>
	 * element = random(1, range) // 100% of chance 
	 * map.remove(element)
	 * </pre>
	 * </code>
	 * 
	 */
	abstract public void removeElement();
	
	/**
	 * Benchmark Copy
	 * 
	 * This benchmark measure the time spent by copying another map structure
	 */
	abstract public void copy();
	

}
