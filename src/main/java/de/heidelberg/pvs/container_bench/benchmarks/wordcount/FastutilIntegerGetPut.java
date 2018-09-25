package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.FastutilMap2IntFact;
import it.unimi.dsi.fastutil.objects.Object2IntMap;

public class FastutilIntegerGetPut extends AbstractWordcountBenchmark<Object2IntMap<Object>> {
	@Param
	public FastutilMap2IntFact impl;

	@Override
	protected Object2IntMap<Object> makeMap() {
		if (size > impl.maxsize) {
			throw new RuntimeException("Skipping because size > maxsize.");
		}
		return impl.maker.get();
	}

	@Override
	protected void count(Object2IntMap<Object> map, String object) {
		map.put(object, map.getInt(object) + 1);
	}

	@Override
	protected int size(Object2IntMap<Object> map) {
		return map.size();
	}
}
