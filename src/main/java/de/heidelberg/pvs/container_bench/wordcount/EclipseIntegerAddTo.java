package de.heidelberg.pvs.container_bench.wordcount;

import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.eclipse.collections.impl.factory.primitive.ObjectIntMaps;
import org.openjdk.jmh.annotations.Param;

public class EclipseIntegerAddTo extends AbstractWordcountBenchmark<MutableObjectIntMap<Object>> {
	@Param({"ECLIPSE_O2I_HASH"})
	public String impl;

	@Override
	protected MutableObjectIntMap<Object> makeMap() {
		return ObjectIntMaps.mutable.empty();
	}

	@Override
	protected int size(MutableObjectIntMap<Object> map) {
		return map.size();
	}

	@Override
	protected void count(MutableObjectIntMap<Object> map, String object) {
		map.addToValue(object, 1);
	}
}
