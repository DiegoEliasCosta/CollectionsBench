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
	 * </pre>    
	 * </code>
	 * 
	 */
	abstract public void addAll();
	
	/**
	 * Benchmark AddElement
	 * 
	 * This benchmark measure the time spent by one <b>random</b> element into 
	 * a full set. The element has 50% of chance of collision.
	 * <code> 
	 * <pre>
	 *     set.add(random(2 * range))
	 *   </pre>  
	 * </code>
	 * 
	 */
	abstract public void addElement();
	
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
	
	/**
	 * TODO
	 */
	abstract public void getSize();
	
	abstract public void removeElement();

}