package de.heidelberg.pvs.container_bench.benchmarks.singleoperations.maps;

import org.openjdk.jmh.annotations.Benchmark;

import com.carrotsearch.hppc.ObjectObjectHashMap;
import com.carrotsearch.hppc.ObjectObjectMap;
import com.carrotsearch.hppc.cursors.ObjectObjectCursor;

public abstract class AbstractHPPCMapBench<K, V> extends AbstractMapBench<K, V> {

	private ObjectObjectMap<K, V> fullMap;
	private K[] keys;
	private K[] newKeys;
	private V[] values;

	protected abstract ObjectObjectMap<K, V> getNewMap();

	protected ObjectObjectMap<K, V> copyMap(ObjectObjectMap<K, V> fullMap2){
		ObjectObjectMap<K, V> map = this.getNewMap();
		map.putAll(fullMap2);
		return map;
	}

	@Override
	public void testSetup() {
		fullMap = this.getNewMap();

		keys = keyGenerator.generateArray(size);
		newKeys = keyGenerator.generateArrayFromPool(size, 2 * size);

		values = valueGenerator.generateArray(size);

		for (int i = 0; i < size; i++) {
			fullMap.put(keys[i], values[i]);
		}

	}

	@Override
	@Benchmark
	public void populate() {
		ObjectObjectMap<K, V> newMap = this.getNewMap();
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
		ObjectObjectMap<K, V> newMap = this.copyMap(fullMap);
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
