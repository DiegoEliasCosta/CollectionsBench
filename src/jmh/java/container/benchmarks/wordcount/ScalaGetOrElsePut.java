package container.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import container.factories.ScalaMapFact;
import scala.collection.mutable.Map;

public class ScalaGetOrElsePut extends AbstractWordcountBenchmark<Map<Object, Integer>> {
	@Param
	public ScalaMapFact impl;

	@SuppressWarnings("unchecked")
	@Override
	protected Map<Object, Integer> makeMap() {
		return (Map<Object, Integer>) impl.maker.get();
	}

	@Override
	protected void count(Map<Object, Integer> map, String object) {
		// Avoid ambiguity:
		map.put(object, ((scala.collection.Map<Object, Integer>) map).getOrElse(object, () -> 0) + 1);
	}

	@Override
	protected long size(Map<Object, Integer> map) {
		return map.iterator().size();
	}
}
