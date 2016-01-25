package de.heidelberg.pvs.container_bench.hppc.maps;

import com.carrotsearch.hppc.IntIntHashMap;

import de.heidelberg.pvs.container_bench.abstracts.AbstractMapTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class HPPC_IntegerInteger_HashMap_Test extends AbstractMapTest<Integer, Integer>{

	
	private IntIntHashMap fullMap;
	private Integer[] keys;
	private Integer[] values;
	

	@Override
	public void testSetup() {
		fullMap = new IntIntHashMap();
		keys = keyGenerator.generateArrayInRange(size, rangeOfKeys);
		values = valueGenerator.generateArray(size);
		for(int i = 0; i < size; i++) {
			fullMap.put(keys[i], values[i]);
		}
		
	}
	
	@Override
	protected RandomGenerator<Integer> instantiateRandomKeyGenerator() {
		return new IntegerRandomGenerator();
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomValueGenerator() {
		return new IntegerRandomGenerator();
	}

	@Override
	public void putAll() {
		IntIntHashMap newMap = new IntIntHashMap();
		for(int i = 0; i < size; i++) {
			blackhole.consume(newMap.put(keys[i], values[i]));
		}
		
	}

	@Override
	public void getElement() {
		int index = keyGenerator.generateIndex(size);
		blackhole.consume(fullMap.containsKey(keys[index]));
	}

	@Override
	public void containsElement() {
		int index = keyGenerator.generateIndex(size);
		blackhole.consume(fullMap.remove(keys[index]));
		
	}

	@Override
	public void removeElement() {
		int index = keyGenerator.generateIndex(size);
		blackhole.consume(fullMap.get(keys[index]));
		
	}

	@Override
	public void copy() {
		IntIntHashMap newMap = new IntIntHashMap(fullMap); 
		blackhole.consume(newMap);
		
	}


}
