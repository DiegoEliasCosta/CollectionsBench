package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.ScalaMapFact;
import scala.Option;
import scala.collection.mutable.Map;

public class MutableScalaGetPut extends AbstractWordcountBenchmark<Map<String, MutableInteger>> {
	@Param
	public ScalaMapFact impl;

	@SuppressWarnings("unchecked")
	@Override
	protected Map<String, MutableInteger> makeMap() {
		return (Map<String, MutableInteger>) (Map<?, ?>) impl.maker.get();
	}

	@Override
	protected void count(Map<String, MutableInteger> map, String object) {
		// Avoid ambiguity:
		Option<MutableInteger> old = ((scala.collection.Map<String, MutableInteger>) map).get(object);
		if (old.isDefined()) {
			old.get().v += 1;
		} else {
			map.put(object, new MutableInteger(1));
		}
	}

	@Override
	protected int size(Map<String, MutableInteger> map) {
		return ((scala.collection.Map<String, MutableInteger>) map).size();
	}
}
