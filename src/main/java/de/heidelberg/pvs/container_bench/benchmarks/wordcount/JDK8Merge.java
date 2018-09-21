package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import java.util.Map;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.JDKMap2IntFact;

public class JDK8Merge extends AbstractWordcountBenchmark<Map<Object, Integer>> {
	@Param
	public JDKMap2IntFact impl;

	@Override
	protected Map<Object, Integer> makeMap() {
		if (size > max_slow_size && (impl.toString().contains("ARRAY") || impl == JDKMap2IntFact.JAVOLUTION_SORTED)) {
			throw new RuntimeException("Skipping because size > max_slow_size.");
		}
		return impl.maker.get();
	}

	@Override
	protected void count(Map<Object, Integer> map, String object) {
		map.merge(object, 1, (x, y) -> x != null ? x + y : y);
	}

	@Override
	protected int size(Map<Object, Integer> map) {
		return map.size();
	}
}
