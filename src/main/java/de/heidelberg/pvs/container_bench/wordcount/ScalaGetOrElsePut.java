package de.heidelberg.pvs.container_bench.wordcount;

import org.openjdk.jmh.annotations.Param;

import scala.collection.mutable.Map;

public class ScalaGetOrElsePut extends AbstractWordcountBenchmark<Map<Object, Integer>> {
	@Param({ "SCALA_O2O_HASH" })
	public String impl;

	@Override
	protected Map<Object, Integer> makeMap() {
		return new scala.collection.mutable.HashMap<Object, Integer>();
	}

	@Override
	protected int size(Map<Object, Integer> map) {
		return map.size();
	}

	@Override
	protected void count(Map<Object, Integer> map, Object object) {
		// Avoid ambiguity:
		map.put(object, ((scala.collection.Map<Object, Integer>) map).getOrElse(object, () -> 0) + 1);
	}
}
