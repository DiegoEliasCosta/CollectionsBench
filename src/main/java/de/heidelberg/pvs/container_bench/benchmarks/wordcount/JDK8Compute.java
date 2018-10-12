package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import java.util.Map;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.JDKMap2IntFact;

public class JDK8Compute extends AbstractWordcountBenchmark<Map<Object, Integer>> {
	@Param
	public JDKMap2IntFact impl;

	@Override
	protected Map<Object, Integer> makeMap() {
		if (size > impl.maxsize) {
			throw new RuntimeException("Skipping because size > maxsize.");
		}
		return impl.maker.get();
	}

	@Override
	protected void count(Map<Object, Integer> map, String object) {
		map.compute(object, (key, value) -> value == null ? 1 : value + 1);
	}

	@Override
	protected int size(Map<Object, Integer> map) {
		return map.size();
	}
}
