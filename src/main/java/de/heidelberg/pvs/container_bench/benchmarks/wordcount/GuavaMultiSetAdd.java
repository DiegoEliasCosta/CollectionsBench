package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import com.google.common.collect.Multiset;

import de.heidelberg.pvs.container_bench.factories.GuavaMultiSetFact;

public class GuavaMultiSetAdd extends AbstractWordcountBenchmark<Multiset<Object>> {
	@Param
	GuavaMultiSetFact impl;

	@Override
	protected Multiset<Object> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected void count(Multiset<Object> map, String object) {
		// Adding an element to a Multiset which already
		// implements the counting
		map.add(object);
	}

	@Override
	protected int size(Multiset<Object> map) {
		return map.elementSet().size(); // unique!
	}
}
