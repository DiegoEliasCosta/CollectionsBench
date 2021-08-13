package container.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import container.factories.ScalaMapFact;
import scala.Option;
import scala.collection.mutable.Map;

public class ScalaGetPut extends AbstractWordcountBenchmark<Map<String, Integer>> {
	@Param
	public ScalaMapFact impl;

	@Override
	protected Map<String, Integer> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected void count(Map<String, Integer> map, String object) {
		// Avoid ambiguity:
		Option<Integer> old = ((scala.collection.Map<String, Integer>) map).get(object);
		map.put(object, old.isDefined() ? old.get() + 1 : 1);
	}
}
