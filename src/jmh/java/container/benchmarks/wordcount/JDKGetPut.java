package container.benchmarks.wordcount;

import java.util.Map;

import org.openjdk.jmh.annotations.Param;

import container.factories.JDKMap2IntFact;

public class JDKGetPut extends AbstractWordcountBenchmark<Map<Object, Integer>> {
	@Param
	public JDKMap2IntFact impl;

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
