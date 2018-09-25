package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import java.util.Map;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.JDKMap2ObjFact;

public class MutableJDK8Compute extends AbstractWordcountBenchmark<Map<Object, MutableInteger>> {
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
		map.compute(object, (key, value) -> {
			if (value == null) {
				value = new MutableInteger(1);
			} else {
				value.v += 1;
			}
			return value;
		});
	}

	@Override
	protected int size(Map<Object, MutableInteger> map) {
		return map.size();
	}
}
