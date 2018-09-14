package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.maps;

import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.EclipseMap2IntFact;

public class EclipseMap2IntBench extends AbstractMap2IntBench {

	@Param
	EclipseMap2IntFact impl;
	
	MutableObjectIntMap<Object> fullMap;
	
	@Override
	public void testSetup() {
		fullMap = impl.maker.get();
		for (int i = 0; i < values.length; i++) {
			fullMap.put(keys[i], values[i]);
		}
		
		
	}
	
	@Override
	protected void populateBench() {
		MutableObjectIntMap<Object> newMap = impl.maker.get();
		for (int i = 0; i < values.length; i++) {
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
		MutableObjectIntMap<Object> newMap = impl.maker.get();
		newMap.putAll(fullMap);
		blackhole.consume(newMap);
	}

	@Override
	protected void iterateKeyBench() {
		fullMap.forEachKey(new Procedure<Object>() {
			@Override
			public void value(Object each) {
				blackhole.consume(each);
			}
		});
	}

	@Override
	protected void iterateKeyValueBench() {
		fullMap.forEachKeyValue(new ObjectIntProcedure<Object>() {
			@Override
			public void value(Object each, int parameter) {
				blackhole.consume(each);
				blackhole.consume(parameter);
			}
		});
	}



}
