package container.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import container.factories.ScalaMapFact;
import scala.collection.mutable.Map;

public class ScalaGetOrElsePut extends AbstractWordcountBenchmark<Map<String, Integer>> {
	@Param
	public ScalaMapFact impl;

	@Override
	protected Map<String, Integer> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected void count(Map<String, Integer> map, String object) {
		// Avoid ambiguity:
		map.put(object, ((scala.collection.Map<String, Integer>) map).getOrElse(object, () -> 0) + 1);
	}
}
