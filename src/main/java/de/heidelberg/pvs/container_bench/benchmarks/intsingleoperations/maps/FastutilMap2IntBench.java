package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.maps;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.FastutilMap2IntFact;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectSet;

public class FastutilMap2IntBench extends AbstractMap2IntBench {

	@Param
	FastutilMap2IntFact impl;
	
	Object2IntMap<Object> fullMap;
	
	@Override
	public void testSetup() {
		fullMap = impl.maker.get();
		for (int i = 0; i < keys.length; i++) {
			fullMap.put(keys[i], values[i]);
		}
	}
	
	@Override
	protected void populateBench() {
		Object2IntMap<Object> newMap = impl.maker.get();
		for (int i = 0; i < keys.length; i++) {
			newMap.put(keys[i], values[i]);
		}
		blackhole.consume(newMap);
	}


	@Override
	protected void containsBench() {
		int index = keyGenerator.generateIndex(size);
		fullMap.containsKey(keys[index]);
	}

	@Override
	protected void copyBench() {
		Object2IntMap<Object> newMap = impl.maker.get();
		newMap.putAll(fullMap);
		blackhole.consume(newMap);
	}

	@Override
	protected void iterateKeyBench() {
		ObjectSet<Object> keySet = fullMap.keySet();
		for(Object key : keySet) {
			blackhole.consume(key);
		}
	}

	@Override
	protected void iterateKeyValueBench() {
		ObjectSet<Entry<Object>> object2IntEntrySet = fullMap.object2IntEntrySet();
		for(Entry<Object> e : object2IntEntrySet) {
			blackhole.consume(e.getKey());
			blackhole.consume(e.getIntValue());
		}
		
	}

}
