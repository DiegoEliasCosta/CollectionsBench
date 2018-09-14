package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.maps;

import org.apache.mahout.math.function.ObjectIntProcedure;
import org.apache.mahout.math.function.ObjectProcedure;
import org.apache.mahout.math.map.OpenObjectIntHashMap;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.MahoutMap2IntFact;

public class MahoutMap2IntBench extends AbstractMap2IntBench {

	@Param
	MahoutMap2IntFact impl;
	
	OpenObjectIntHashMap<Object> fullMap;
	
	@Override
	public void testSetup() {
		fullMap = impl.maker.get();
		for (int i = 0; i < keys.length; i++) {
			fullMap.put(keys[i], values[i]);
		}
	}
	
	@Override
	protected void populateBench() {
		OpenObjectIntHashMap<Object> newMap = impl.maker.get();
		for (int i = 0; i < keys.length; i++) {
			newMap.put(keys[i], values[i]);
		}
		blackhole.consume(newMap);
	}

	@Override
	protected void containsBench() {
		int index = keyGenerator.generateIndex(size);
		blackhole.consume(fullMap.containsKey(keys[index]));
	}


	@Override
	protected void copyBench() {
		OpenObjectIntHashMap<Object> newMap = (OpenObjectIntHashMap<Object>) fullMap.copy();
		blackhole.consume(newMap);
	}

	@Override
	protected void iterateKeyBench() {
		fullMap.forEachKey(new ObjectProcedure<Object>() {
			@Override
			public boolean apply(Object element) {
				blackhole.consume(element);
				return false;
			}
		});
	}

	@Override
	protected void iterateKeyValueBench() {
		fullMap.forEachPair(new ObjectIntProcedure<Object>() {
			@Override
			public boolean apply(Object first, int second) {
				blackhole.consume(first);
				blackhole.consume(second);
				return false;
			}
		});
	}

}
