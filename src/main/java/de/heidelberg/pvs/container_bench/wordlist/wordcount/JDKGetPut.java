package de.heidelberg.pvs.container_bench.wordlist.wordcount;

import java.util.Map;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.JDKMapFact;

public class JDKGetPut extends AbstractWordcountBenchmark<Map<Object, Integer>> {
	@Param
	public JDKMapFact impl;

	@Override
	protected Map<Object, Integer> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected void count(Map<Object, Integer> map, String object) {
		final Integer old = map.get(object);
		map.put(object, old != null ? old + 1 : 1);
	}
}
