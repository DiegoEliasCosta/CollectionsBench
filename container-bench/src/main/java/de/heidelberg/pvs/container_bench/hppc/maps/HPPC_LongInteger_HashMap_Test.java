package de.heidelberg.pvs.container_bench.hppc.maps;

import com.carrotsearch.hppc.LongIntHashMap;

import de.heidelberg.pvs.container_bench.abstracts.AbstractMapTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class HPPC_LongInteger_HashMap_Test extends AbstractMapTest<Long, Integer>{

	
	private LongIntHashMap fullMap;
	private Long[] keys;
	private Integer[] values;
	

	@Override
	public void testSetup() {
		fullMap = new LongIntHashMap();
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
	public void putAll() {
		LongIntHashMap newMap = new LongIntHashMap();
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
		LongIntHashMap newMap = new LongIntHashMap(fullMap); 
		blackhole.consume(newMap);
		
	}


}
