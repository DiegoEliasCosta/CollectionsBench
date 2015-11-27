package de.heidelberg.pvs.container_bench.abstracts.jdk;

import java.util.Map;

import org.openjdk.jmh.annotations.Benchmark;

import de.heidelberg.pvs.container_bench.abstracts.AbstractMapTest;

public abstract class AbstractJDKMapTest<K, V> extends AbstractMapTest<K, V> {

	private Map<K, V> fullMap;
	private K[] keys;
	private V[] values;
	
	protected abstract Map<K, V> getNewMap(int size, int range);
	protected abstract Map<K, V> copyMap(Map<K, V> fullMap2);
	
	@Override
	public void testSetup() {
		fullMap = this.getNewMap(size, rangeOfKeys);
		
		keys = keyGenerator.generateArrayInRange(size, rangeOfKeys);
		values = valueGenerator.generateArray(size);

		for(int i = 0; i < size; i++) {
			fullMap.put(keys[i], values[i]);
		}
		
	}
	
	@Override
	@Benchmark
	public void putAll() {
		Map<K, V> newMap = this.getNewMap(size, rangeOfKeys);
		for(int i = 0; i < size; i++) {
			blackhole.consume(newMap.put(keys[i], values[i]));
		}
	}
	
	

	@Override
	@Benchmark
	public void containsElement() {
		int index = keyGenerator.generateIndex(size);
		blackhole.consume(fullMap.containsKey(keys[index]));
	}

	@Override
	@Benchmark
	public void removeElement() {
		int index = keyGenerator.generateIndex(size);
		blackhole.consume(fullMap.remove(keys[index]));
	}

	@Override
	@Benchmark
	public void getElement() {
		int index = keyGenerator.generateIndex(size);
		blackhole.consume(fullMap.get(keys[index]));
		
	}

	@Override
	public void copy() {
		Map<K, V> newMap = this.copyMap(fullMap); 
		blackhole.consume(newMap);
	}

	
}
