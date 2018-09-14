package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.maps;

import java.util.function.Consumer;

import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.ObjectCollection;
import com.carrotsearch.hppc.ObjectIntMap;
import com.carrotsearch.hppc.cursors.ObjectIntCursor;

import de.heidelberg.pvs.container_bench.factories.HPPCMap2IntFact;

public class HPPCMap2IntBench extends AbstractMap2IntBench {

	@Param
	HPPCMap2IntFact impl;
	
	ObjectIntMap<Object> fullMap;
	
	@Override
	public void testSetup() {
		fullMap = impl.maker.get();
		for (int i = 0; i < keys.length; i++) {
			fullMap.put(keys[i], values[i]);
		}
	}
	
	@Override
	protected void populateBench() {
		ObjectIntMap<Object> newMap = impl.maker.get();
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
		ObjectIntMap<Object> newMap = impl.maker.get();
		newMap.putAll(fullMap);
		blackhole.consume(newMap);
	}

	@Override
	protected void iterateKeyBench() {
		ObjectCollection<Object> keys2 = fullMap.keys();
		for(Object e : keys2) {
			blackhole.consume(e);
		}
		blackhole.consume(keys2);
	}

	@Override
	protected void iterateKeyValueBench() {
		
		fullMap.forEach(new Consumer<ObjectIntCursor<Object>>() {
			@Override
			public void accept(ObjectIntCursor<Object> t) {
				blackhole.consume(t.key);
				blackhole.consume(t.value);
			}
		});
	}

}
