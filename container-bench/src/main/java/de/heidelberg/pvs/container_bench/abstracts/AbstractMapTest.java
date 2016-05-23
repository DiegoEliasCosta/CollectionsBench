package de.heidelberg.pvs.container_bench.abstracts;

import org.openjdk.jmh.annotations.Param;

import com.google.common.reflect.TypeToken;

import de.heidelberg.pvs.container_bench.random.RandomFactory;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public abstract class AbstractMapTest<K, V> extends AbstractBenchmarkTest {

	@Param({ "50" })
	public int percentageRangeKeys;

	protected RandomGenerator<K> keyGenerator = this.instantiateRandomKeyGenerator();
	protected RandomGenerator<V> valueGenerator = this.instantiateRandomValueGenerator();

	/**
	 * Implementation of our Randomness 
	 */
	@Override
	public void randomnessSetup() {
		keyGenerator.setSeed(seed);	
		valueGenerator.setSeed(seed);
		this.testSetup();
	}
	
	@SuppressWarnings({ "serial", "unchecked" })
	private RandomGenerator<V> instantiateRandomValueGenerator() {
		TypeToken<V> type = new TypeToken<V>(getClass()) {};
		return (RandomGenerator<V>) RandomFactory.buildRandomGenerator(type);
	}

	@SuppressWarnings({ "serial", "unchecked" })
	private RandomGenerator<K> instantiateRandomKeyGenerator() {
		TypeToken<K> type = new TypeToken<K>(getClass()) {};
		return (RandomGenerator<K>) RandomFactory.buildRandomGenerator(type);
	}

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
	abstract public void addAll();
	
	/**
	 * Benchmark PutElement
	 * 
	 * This benchmark measure the time spent at putting one elements into
	 * a full map. The element has 50% of chance of collision. <code>
	 * <pre>
	 * for(;;)
	 *   element = random(2 * range)
	 *   map.put(element)
	 * </pre>
	 * </code>
	 * 
	 */
	abstract public void addElement();

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
	 * Benchmark Copy
	 * 
	 * This benchmark measure the time spent by copying another map structure
	 * TODO
	 */
	abstract public void copy();
	
	/**
	 * TODO
	 */
	abstract public void getSize();
	
	abstract public void removeElement();
	
	abstract public void getAll();
	

}
