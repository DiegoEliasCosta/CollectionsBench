package de.heidelberg.pvs.container_bench.abstracts;

import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public abstract class AbstractSetTest<T> extends AbstractBenchmarkTest { 
	
	
	/**
	 * Implementation of our Randomness 
	 */
	protected RandomGenerator<T> generator = this.instantiateRandomGenerator();
	
	/**
	 * Abstract method that returns {@link RandomGenerator}
	 * @return
	 */
	protected abstract RandomGenerator<T> instantiateRandomGenerator();

	@Override
	public void randomnessSetup() {
		generator.setSeed(seed);	
		this.testSetup();
	}
	
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