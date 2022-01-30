package container.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import container.factories.ScalaMapFact;
import scala.Option;
import scala.collection.mutable.Map;

public class ScalaGetPut extends AbstractWordcountBenchmark<Map<Object, Integer>> {
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
		Option<Integer> old = ((scala.collection.Map<Object, Integer>) map).get(object);
		map.put(object, old.isDefined() ? old.get() + 1 : 1);
	}

	@Override
	protected long size(Map<Object, Integer> map) {
		return map.iterator().size();
	}
}
