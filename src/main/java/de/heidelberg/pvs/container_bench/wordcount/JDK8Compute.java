package de.heidelberg.pvs.container_bench.wordcount;

import java.util.Map;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.JDKMapFact;

public class JDK8Compute extends AbstractWordcountBenchmark<Map<Object, Integer>> {
	@Param
	public JDKMapFact impl;

	@Override
	protected Map<Object, Integer> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected void count(Map<Object, Integer> map, String object) {
		map.compute(object, (key, value) -> value == null ? 1 : value + 1);
	}
}
