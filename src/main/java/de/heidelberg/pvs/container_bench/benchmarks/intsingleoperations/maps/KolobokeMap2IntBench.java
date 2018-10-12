package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.maps;

import java.util.function.ObjIntConsumer;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.KolobokeMap2IntFact;
import com.koloboke.collect.map.hash.HashObjIntMap;
import com.koloboke.collect.set.hash.HashObjSet;

public class KolobokeMap2IntBench extends AbstractMap2IntBench {

	@Param
	KolobokeMap2IntFact impl;
	
	HashObjIntMap<Object> fullMap;
	
	@Override
	public void testSetup() {
		fullMap = impl.maker.get();
		for (int i = 0; i < keys.length; i++) {
			fullMap.put(keys[i], values[i]);
		}
	}
	
	@Override
	protected void populateBench() {
		HashObjIntMap<Object> newMap = impl.maker.get();
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
		HashObjIntMap<Object> newMap = impl.maker.get();
		newMap.putAll(fullMap);
		blackhole.consume(newMap);
	}

	@Override
	protected void iterateKeyBench() {
		HashObjSet<Object> keySet = fullMap.keySet();
		for(Object e: keySet) {
			blackhole.consume(e);
		}
		blackhole.consume(keySet);
	}

	@Override
	protected void iterateKeyValueBench() {
		fullMap.forEach(new ObjIntConsumer<Object>() {
			@Override
			public void accept(Object t, int value) {
				blackhole.consume(t);
				blackhole.consume(value);
			}
		});
	}
}
