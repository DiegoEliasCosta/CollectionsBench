package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import org.eclipse.collections.api.map.MutableMapIterable;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.EclipseMapFact;

public class EclipseUpdateValue extends AbstractWordcountBenchmark<MutableMapIterable<Object, Integer>> {
	@Param
	public EclipseMapFact impl;

	@Override
	protected MutableMapIterable<Object, Integer> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected void count(MutableMapIterable<Object, Integer> map, String object) {
		map.updateValue(object, () -> 0, x -> x + 1);
	}

	@Override
	protected int size(MutableMapIterable<Object, Integer> map) {
		return map.size();
	}
}
