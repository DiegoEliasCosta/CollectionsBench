package de.heidelberg.pvs.container_bench.abstracts.guava;

import com.google.common.collect.Multimap;

import de.heidelberg.pvs.container_bench.abstracts.AbstractMapTest;

public abstract class AbstractGuavaMultiMapTest<K, V> extends AbstractMapTest<K, V> {

	private K[] keys;
	private V[] values;
	private Multimap<K, V> fullMap;

	protected abstract Multimap<K, V> getNewMultiMap(int size, int rangeOfKeys);

	protected abstract Multimap<K, V> copyMultiMap(Multimap<K, V> original);

	@Override
	public void testSetup() {

		fullMap = this.getNewMultiMap(size, rangeOfKeys);

		keys = keyGenerator.generateArrayInRange(size, rangeOfKeys);
		values = valueGenerator.generateArray(size);

		for (int i = 0; i < size; i++) {
			fullMap.put(keys[i], values[i]);
		}

	}

	@Override
	public void putAll() {
		Multimap<K, V> newMap = this.getNewMultiMap(size, rangeOfKeys);
		for(int i = 0; i < size; i++) {
			blackhole.consume(newMap.put(keys[i], values[i]));
		}
	}

	@Override
	public void getElement() {
		int index = keyGenerator.generateIndex(size);
		blackhole.consume(fullMap.get(keys[index]));
	}

	@Override
	public void containsElement() {
		int index = keyGenerator.generateIndex(size);
		blackhole.consume(fullMap.containsKey(keys[index]));
	}

	@Override
	public void removeElement() {
		int index = keyGenerator.generateIndex(size);
		blackhole.consume(fullMap.remove(keys[index], values[index]));

	}

	@Override
	public void copy() {
		Multimap<K, V> newMap = this.copyMultiMap(fullMap); 
		blackhole.consume(newMap);
	}

}
