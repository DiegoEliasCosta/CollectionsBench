package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.maps;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.TroveMap2IntFact;
import gnu.trove.map.TObjectIntMap;
import gnu.trove.procedure.TObjectIntProcedure;
import gnu.trove.procedure.TObjectProcedure;

public class TroveMap2IntBench extends AbstractMap2IntBench {

	@Param
	TroveMap2IntFact impl;
	
	TObjectIntMap<Object> fullMap;
	
	@Override
	public void testSetup() {
		fullMap = impl.maker.get();
		for (int i = 0; i < keys.length; i++) {
			fullMap.put(keys[i], values[i]);
		}
	}
	
	@Override
	protected void populateBench() {
		TObjectIntMap<Object> newMap = impl.maker.get();
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
		TObjectIntMap<Object> newMap = impl.maker.get();
		newMap.putAll(fullMap);
		blackhole.consume(newMap);
	}

	@Override
	protected void iterateKeyBench() {
		fullMap.forEachKey(new TObjectProcedure<Object>() {
			@Override
			public boolean execute(Object object) {
				blackhole.consume(object);
				return true; // call additional 
			}
		});
				
	}

	@Override
	protected void iterateKeyValueBench() {
		fullMap.forEachEntry(new TObjectIntProcedure<Object>() {
			@Override
			public boolean execute(Object a, int b) {
				blackhole.consume(a);
				blackhole.consume(b);
				return true;
			}
		});
	}
}
