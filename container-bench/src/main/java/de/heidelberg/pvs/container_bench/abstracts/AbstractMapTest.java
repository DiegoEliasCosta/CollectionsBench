package de.heidelberg.pvs.container_bench.abstracts;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public abstract class AbstractMapTest<K, V> extends AbstractBenchmarkTest {

	@Param({ "10", "100", "1000", "10000" })
	public int rangeOfKeys;

	protected RandomGenerator<K> keyGenerator = this.instantiateRandomKeyGenerator();
	protected abstract RandomGenerator<K> instantiateRandomKeyGenerator();
	
	protected RandomGenerator<V> valueGenerator = this.instantiateRandomValueGenerator();
	protected abstract RandomGenerator<V> instantiateRandomValueGenerator();

	/**
	 * Implementation of our Randomness 
	 */
	@Override
	public void randomnessSetup() {
		keyGenerator.setSeed(seed);	
		valueGenerator.setSeed(seed);
		this.testSetup();
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
	abstract public void addAndRemoveElement();

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
	 */
	abstract public void copyMap();
	

}
