package de.heidelberg.pvs.container_bench.abstracts;

public abstract class AbstractSetTest extends AbstractBenchmarkTest { 
	
	// Crude copy/paste of AbstractListTest -- Janos
	
	/**
	 * Benchmark GetAll
	 * 
	 * This benchmark measure the time spent in traversing the set. <br>
	 * <code> 
	 * <pre>
	 * for(;;) 
	 *     set.get(i) 
	 * </pre> 
	 * </code> 
	 */
	abstract public void getAll();

	/**
	 * Benchmark GetAt
	 * 
	 * This benchmark measure the time spent in getting an element in a
	 * <b>random</b> position of the set <br>
	 * <br>
	 * <code>
	 * index = random() <br>
	 * set.get(index); <br>
	 * </code>
	 * 
	 */
	abstract public void getElement();

	/**
	 * Benchmark RemoveAt
	 * 
	 * This benchmark measure the time spent in removing a <b>random</b> element
	 * of the set. <br>
	 * <br>
	 * <code>
	 * index = random() <br>
	 * set.remove(index)
	 * </code>
	 */
	abstract public void removeElement();

	/**
	 * Benchmark Clear
	 * 
	 * This benchmark measure the time spent in clearing the set <br>
	 * <br>
	 * <code>
	 * set.clear()
	 * </code>
	 * 
	 */
	abstract public void clear();

	/**
	 * Benchmark Contains
	 * 
	 * This benchmark measure the time spent executing a contain to a <b>random</b>
	 * element in the set
	 * <br> <br>
	 * <code>
	 * randomElement = random()
	 * set.contains(randomElement)
	 * </code>
	 * 
	 */
	abstract public void containsElement();

	/**
	 * Benchmark Instantiate
	 * 
	 * This benchmark measure the time spent by creating a new set
	 * <br><br>
	 * <code>
	 * set = new set()
	 * </code>
	 */
	abstract public void instantiate();

	/**
	 * Benchmark AddAll
	 * 
	 * This benchmark measure the time spent by adding <b>random</b> elements into 
	 * the set, until it reaches its specified size
	 * <code> 
	 * <pre>
	 * for(;;) 
	 *     set.add(random())
	 * </code>
	 * 
	 */
	abstract public void addAll();
	
	/**
	 * Benchmark Copy
	 * 
	 * This benchmark measure the time spent by copying the entire set to a new instance
	 * <code>
	 * <pre>
	 * newset = copy(oldSet)
	 * </pre>
	 * </code>
	 * 
	 */
	abstract public void copySet();

}