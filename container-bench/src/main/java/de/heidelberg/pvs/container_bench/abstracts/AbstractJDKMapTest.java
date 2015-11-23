package de.heidelberg.pvs.container_bench.abstracts;

import java.util.Map;

import org.openjdk.jmh.annotations.Benchmark;

public abstract class AbstractJDKMapTest<K, V> extends AbstractMapTest {

	private Map<K, V> fullMap;
	private K[] keys;
	private V[] values;
	
	protected abstract Map<K, V> getNewMap(int size, int range);
	
	protected abstract int generateRandomIndex(int size);
	
	protected abstract K[] generateRandomKeys(int size, int range);
	protected abstract K generateRandomKey(int range);
	
	protected abstract V[] generateRandomValues(int size, int range);
	protected abstract V generateRandomValue(int range);
	
	protected abstract Map<K, V> copyMap(Map<K, V> fullMap2);
	
	@Override
	public void setup() {
		fullMap = this.getNewMap(size, rangeOfKeys);
		
		keys = this.generateRandomKeys(size, rangeOfKeys);
		values = this.generateRandomValues(size, rangeOfKeys);

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
		int index = this.generateRandomIndex(size);
		blackhole.consume(fullMap.containsKey(keys[index]));
	}

	// FIXME: How to test remove from a state object? 
	@Override
	//@Benchmark
	public void removeElement() {
		int index = this.generateRandomIndex(size);
		blackhole.consume(fullMap.remove(keys[index]));
	}

	@Override
	@Benchmark
	public void getElement() {
		int index = this.generateRandomIndex(size);
		blackhole.consume(fullMap.get(keys[index]));
		
	}

	@Override
	public void copy() {
		Map<K, V> newMap = this.copyMap(fullMap); 
		blackhole.consume(newMap);
	}

	
}
