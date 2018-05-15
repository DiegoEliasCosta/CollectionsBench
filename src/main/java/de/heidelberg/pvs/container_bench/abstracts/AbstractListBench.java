package de.heidelberg.pvs.container_bench.abstracts;

import java.io.IOException;

import de.heidelberg.pvs.container_bench.generators.ElementGenerator;
import de.heidelberg.pvs.container_bench.generators.GeneratorFactory;

public abstract class AbstractListBench<T> extends AbstractBench {

	/**
	 * Implementation of our Randomness
	 */
	protected ElementGenerator<T> generator;

	@SuppressWarnings("unchecked")
	@Override
	public void elementGenerationSetup() throws IOException {
		generator = (ElementGenerator<T>) GeneratorFactory.buildRandomGenerator(payloadType);
		generator.init(size, seed);
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