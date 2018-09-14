package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.EclipseMap2IntFact;

public class EclipseIntegerAddTo extends AbstractWordcountBenchmark<MutableObjectIntMap<Object>> {
	@Param
	public EclipseMap2IntFact impl;

	@Override
	protected MutableObjectIntMap<Object> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected void count(MutableObjectIntMap<Object> map, String object) {
		map.addToValue(object, 1);
	}

	@Override
	protected int size(MutableObjectIntMap<Object> map) {
		return map.size();
	}
}
