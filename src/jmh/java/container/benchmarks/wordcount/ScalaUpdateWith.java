package container.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import container.factories.ScalaMapFact;
import scala.Some;
import scala.collection.mutable.Map;

public class ScalaUpdateWith extends AbstractWordcountBenchmark<Map<String, Integer>> {
	@Param
	public ScalaMapFact impl;

	@Override
	protected Map<String, Integer> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected void count(Map<String, Integer> map, String object) {
		map.updateWith(object, (x) -> new Some<Integer>(x.getOrElse(() -> 0) + 1));
	}

	@Override
	protected long size(Map<String, Integer> map) {
		return map.iterator().size();
	}
}
