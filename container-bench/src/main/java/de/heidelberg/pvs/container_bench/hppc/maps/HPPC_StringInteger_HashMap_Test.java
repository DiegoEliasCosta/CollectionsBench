package de.heidelberg.pvs.container_bench.hppc.maps;

import org.openjdk.jmh.annotations.Benchmark;

import com.carrotsearch.hppc.ObjectObjectHashMap;

import de.heidelberg.pvs.container_bench.abstracts.AbstractMapTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;

public class HPPC_StringInteger_HashMap_Test extends AbstractMapTest<String, Integer>{

	
	private ObjectObjectHashMap<String, Integer> fullMap;
	private String[] keys;
	private Integer[] values;
	

	@Override
	public void testSetup() {
		fullMap = new ObjectObjectHashMap<>();
		keys = keyGenerator.generateArrayInRange(size, rangeOfKeys);
		values = valueGenerator.generateArray(size);
		for(int i = 0; i < size; i++) {
			fullMap.put(keys[i], values[i]);
		}
		
	}
	
	@Override
	protected RandomGenerator<String> instantiateRandomKeyGenerator() {
		return new StringRandomGenerator();
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomValueGenerator() {
		return new IntegerRandomGenerator();
	}

	@Override
	@Benchmark
	public void putAll() {
		ObjectObjectHashMap<String, Integer> newMap = new ObjectObjectHashMap<>();
		for(int i = 0; i < size; i++) {
			blackhole.consume(newMap.put(keys[i], values[i]));
		}
		
	}

	@Override
	@Benchmark
	public void getElement() {
		int index = keyGenerator.generateIndex(size);
		blackhole.consume(fullMap.containsKey(keys[index]));
	}

	@Override
	@Benchmark
	public void containsElement() {
		int index = keyGenerator.generateIndex(size);
		blackhole.consume(fullMap.remove(keys[index]));
		
	}

	@Override
	@Benchmark
	public void removeElement() {
		int index = keyGenerator.generateIndex(size);
		blackhole.consume(fullMap.get(keys[index]));
		
	}

	@Override
	@Benchmark
	public void copyMap() {
		ObjectObjectHashMap<String, Integer> newMap = new ObjectObjectHashMap<>(fullMap); 
		blackhole.consume(newMap);
		
	}


}
