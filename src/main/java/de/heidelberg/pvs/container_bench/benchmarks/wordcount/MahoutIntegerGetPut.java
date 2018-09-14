package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import org.apache.mahout.math.map.OpenObjectIntHashMap;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.MahoutMap2IntFact;

public class MahoutIntegerGetPut extends AbstractWordcountBenchmark<OpenObjectIntHashMap<Object>> {
	@Param
	public MahoutMap2IntFact impl;

	@Override
	protected OpenObjectIntHashMap<Object> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected void count(OpenObjectIntHashMap<Object> map, String object) {
		map.put(object, map.get(object) + 1);
	}

	@Override
	protected int size(OpenObjectIntHashMap<Object> map) {
		return map.size();
	}
}
