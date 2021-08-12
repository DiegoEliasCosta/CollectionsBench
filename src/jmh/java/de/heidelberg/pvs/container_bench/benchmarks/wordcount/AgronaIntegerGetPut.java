package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import org.agrona.collections.Object2IntHashMap;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.AgronaMap2IntFact;

public class AgronaIntegerGetPut extends AbstractWordcountBenchmark<Object2IntHashMap<Object>> {
	@Param
	public AgronaMap2IntFact impl;

	@Override
	protected Object2IntHashMap<Object> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected void count(Object2IntHashMap<Object> map, String object) {
		map.put(object, map.getValue(object) + 1);
	}
}
