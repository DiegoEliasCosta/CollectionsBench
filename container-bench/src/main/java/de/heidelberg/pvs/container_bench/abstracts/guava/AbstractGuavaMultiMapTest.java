package de.heidelberg.pvs.container_bench.abstracts.guava;

import java.util.Map.Entry;

import org.openjdk.jmh.annotations.Benchmark;

import com.google.common.collect.Multimap;

import de.heidelberg.pvs.container_bench.abstracts.AbstractMapTest;

public abstract class AbstractGuavaMultiMapTest<K, V> extends AbstractMapTest<K, V> {

	private K[] keys;
	private K[] newKeys;
	private V[] values;
	private Multimap<K, V> fullMap;

	protected abstract Multimap<K, V> getNewMultiMap(int size, int rangeOfKeys);

	protected abstract Multimap<K, V> copyMultiMap(Multimap<K, V> original);

	@Override
	public void testSetup() {

		int varietyOfKeys = (int) (size * ((double)percentageRangeKeys / 100));
		fullMap = this.getNewMultiMap(size, varietyOfKeys);

		keys = keyGenerator.generateArrayInRange(size, varietyOfKeys);
		newKeys = keyGenerator.generateArrayInRange(size, 2 * varietyOfKeys); // 50 % of colision
		values = valueGenerator.generateArray(size);

		for (int i = 0; i < size; i++) {
			fullMap.put(keys[i], values[i]);
		}

	}

	@Override
	@Benchmark
	public void addAll() {
		Multimap<K, V> newMap = this.getNewMultiMap(size, percentageRangeKeys);
		for(int i = 0; i < size; i++) {
			blackhole.consume(newMap.put(keys[i], values[i]));
		}
	}
	
	@Override
	@Benchmark
	public void addElement() {
		Integer index = this.keyGenerator.generateIndex(size);
		blackhole.consume(this.fullMap.put(newKeys[index], values[index]));
		blackhole.consume(this.fullMap.remove(newKeys[index], values[index]));
	}

	@Override
	@Benchmark
	public void getElement() {
		int index = keyGenerator.generateIndex(size);
		blackhole.consume(fullMap.get(keys[index]));
	}

	@Override
	@Benchmark
	public void containsElement() {
		int index = keyGenerator.generateIndex(size);
		blackhole.consume(fullMap.containsKey(keys[index]));
	}


	@Override
	@Benchmark
	public void copy() {
		Multimap<K, V> newMap = this.copyMultiMap(fullMap); 
		blackhole.consume(newMap);
	}
	
	@Override
	@Benchmark
	public void removeElement() {
		Integer index = this.keyGenerator.generateIndex(size);
		blackhole.consume(this.fullMap.remove(keys[index], values[index]));
		blackhole.consume(this.fullMap.put(keys[index], values[index])); // Keeping the steady-state
	}
	
	@Override
	@Benchmark
	public void getAll() {
		for(Entry<K, V> entry : this.fullMap.entries()) {
			blackhole.consume(entry);
		}
	}

}
