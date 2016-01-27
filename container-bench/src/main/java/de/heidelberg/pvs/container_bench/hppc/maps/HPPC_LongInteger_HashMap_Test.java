package de.heidelberg.pvs.container_bench.hppc.maps;

import org.openjdk.jmh.annotations.Benchmark;

import com.carrotsearch.hppc.ObjectObjectHashMap;

import de.heidelberg.pvs.container_bench.abstracts.AbstractMapTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class HPPC_LongInteger_HashMap_Test extends AbstractMapTest<Long, Integer>{

	
	private ObjectObjectHashMap<Long, Integer> fullMap;
	private Long[] keys;
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
	protected RandomGenerator<Long> instantiateRandomKeyGenerator() {
		return new LongRandomGenerator();
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomValueGenerator() {
		return new IntegerRandomGenerator();
	}

	@Override
	@Benchmark
	public void putAll() {
		ObjectObjectHashMap<Long, Integer> newMap = new ObjectObjectHashMap<>();
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
		ObjectObjectHashMap<Long, Integer> newMap = new ObjectObjectHashMap<>(fullMap); 
		blackhole.consume(newMap);
		
	}


}
