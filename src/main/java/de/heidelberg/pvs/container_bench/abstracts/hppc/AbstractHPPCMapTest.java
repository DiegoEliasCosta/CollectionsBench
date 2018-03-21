package de.heidelberg.pvs.container_bench.abstracts.hppc;

import org.openjdk.jmh.annotations.Benchmark;

import com.carrotsearch.hppc.ObjectObjectHashMap;
import com.carrotsearch.hppc.cursors.ObjectObjectCursor;

import de.heidelberg.pvs.container_bench.abstracts.AbstractMapTest;

public abstract class AbstractHPPCMapTest<K, V> extends AbstractMapTest<K, V> {

	private ObjectObjectHashMap<K, V> fullMap;
	private K[] keys;
	private K[] newKeys;
	private V[] values;

	protected abstract ObjectObjectHashMap<K, V> getNewMap(int size, int range);

	protected abstract ObjectObjectHashMap<K, V> copyMap(ObjectObjectHashMap<K, V> fullMap2);

	@Override
	public void testSetup() {
		int varietyOfKeys = (int) (size * ((double) percentageRangeKeys / 100));
		fullMap = this.getNewMap(size, varietyOfKeys);

		keys = keyGenerator.generateArray(size);
		newKeys = keyGenerator.generateArrayInRange(size, 2 * size);

		values = valueGenerator.generateArray(size);

		for (int i = 0; i < size; i++) {
			fullMap.put(keys[i], values[i]);
		}

	}

	@Override
	@Benchmark
	public void populate() {
		ObjectObjectHashMap<K, V> newMap = this.getNewMap(size, percentageRangeKeys);
		for (int i = 0; i < size; i++) {
			newMap.put(keys[i], values[i]);
		}
		blackhole.consume(newMap);
	}

	@Override
	@Benchmark
	public void addElement() {
		int index = this.keyGenerator.generateIndex(size);
		blackhole.consume(this.fullMap.put(newKeys[index], values[index]));
		blackhole.consume(this.fullMap.remove(newKeys[index]));
	}

	@Override
	@Benchmark
	public void containsElement() {
		int index = keyGenerator.generateIndex(size);
		blackhole.consume(fullMap.containsKey(keys[index]));
	}

	@Override
	@Benchmark
	public void getElement() {
		int index = keyGenerator.generateIndex(size);
		blackhole.consume(fullMap.get(keys[index]));

	}

	@Override
	@Benchmark
	public void copy() {
		ObjectObjectHashMap<K, V> newMap = this.copyMap(fullMap);
		blackhole.consume(newMap);
	}

	@Override
	@Benchmark
	public void removeElement() {
		int index = this.keyGenerator.generateIndex(size);
		blackhole.consume(this.fullMap.remove(keys[index]));
		blackhole.consume(this.fullMap.put(keys[index], values[index])); // Keeping
	}

	@Override
	@Benchmark
	public void iterate() {
		for (ObjectObjectCursor<K, V> c : fullMap) {
			blackhole.consume(c);
		}
	}

	@Override
	protected Object getFullCollection() {
		return fullMap;
	}
	
}
