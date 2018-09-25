package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import java.util.Map;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.JDKMap2ObjFact;

public class MutableJDKGetPut extends AbstractWordcountBenchmark<Map<Object, MutableInteger>> {
	@Param
	public JDKMap2ObjFact impl;

	@SuppressWarnings("unchecked")
	@Override
	protected Map<Object, MutableInteger> makeMap() {
		if (size > impl.maxsize) {
			throw new RuntimeException("Skipping because size > maxsize.");
		}
		return (Map<Object, MutableInteger>) (Map<?, ?>) impl.maker.get();
	}

	@Override
	protected void count(Map<Object, MutableInteger> map, String object) {
		final MutableInteger old = map.get(object);
		if (old != null) {
			old.v++;
		} else {
			map.put(object, new MutableInteger(1));
		}
	}

	@Override
	protected int size(Map<Object, MutableInteger> map) {
		return map.size();
	}
}
