package de.heidelberg.pvs.container_bench.abstracts;

import com.google.common.reflect.TypeToken;

import de.heidelberg.pvs.container_bench.random.RandomFactory;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public abstract class AbstractListTest<T> extends AbstractBenchmarkTest {

	/**
	 * Implementation of our Randomness
	 */
	protected RandomGenerator<T> generator = this.instantiateRandomGenerator();

	/**
	 * Builds and returns the correct generator {@link RandomGenerator}. In
	 * order to find the generator type we use TypeToken from Guava, which uses
	 * reflection to infer the subclass type.
	 * 
	 * @return
	 */
	@SuppressWarnings({ "serial", "unchecked" })
	private RandomGenerator<T> instantiateRandomGenerator() {
		TypeToken<T> type = new TypeToken<T>(getClass()) {
		};
		return (RandomGenerator<T>) RandomFactory.buildRandomGenerator(type);
	}

	@Override
	public void randomnessSetup() {
		generator.setSeed(seed);
		this.testSetup();
	}

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
	abstract public void iterate();

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
	abstract public void getElement();

	/**
	 * Benchmark Contains
	 * 
	 * This benchmark measure the time spent executing a contain to a
	 * <b>random</b> element in the list <br>
	 * <br>
	 * <code>
	 * randomElement = random()
	 * list.contains(randomElement)
	 * </code>
	 * 
	 */
	abstract public void containsElement();

	/**
	 * Benchmark AddAll
	 * 
	 * This benchmark measure the time spent by adding <b>random</b> elements
	 * into the list, until it reaches its specified size <code> 
	 * <pre>
	 * for(;;) 
	 *     list.add(random())
	 * </code>
	 * 
	 */
	abstract public void populate();

	/**
	 * Benchmark Copy
	 * 
	 * This benchmark measure the time spent by copying the entire list to a new
	 * instance <code>
	 * <pre>
	 * newlist = copy(oldList)
	 * </pre>
	 * </code>
	 * 
	 */
	abstract public void copy();

	/**
	 * Steady-State performance solution for testing addElement
	 * 
	 * TODO
	 */
	abstract public void addElement();

	abstract public void removeElement();
	

	
}