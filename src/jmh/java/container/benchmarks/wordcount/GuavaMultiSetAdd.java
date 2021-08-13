package container.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import com.google.common.collect.Multiset;

import container.factories.GuavaMultiSetFact;

public class GuavaMultiSetAdd extends AbstractWordcountBenchmark<Multiset<Object>> {
	@Param
	GuavaMultiSetFact impl;
	
	@SuppressWarnings("unchecked")
	@Override
	protected Multiset<Object> makeMap() {
		// Must be comparable, and String is fine
		return (Multiset<Object>) impl.maker.get();
	}

	@Override
	protected void count(Multiset<Object> map, String object) {
		// Adding an element to a Multiset which already
		// implements the counting
		map.add(object);
	}
}
