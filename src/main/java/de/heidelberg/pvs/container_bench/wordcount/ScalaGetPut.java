package de.heidelberg.pvs.container_bench.wordcount;

import java.util.function.Supplier;

import org.openjdk.jmh.annotations.Param;

import scala.Option;
import scala.collection.mutable.Map;

public class ScalaGetPut extends AbstractWordcountBenchmark<Map<String, Integer>> {
	@Param
	public ImplEnum impl;

	public static enum ImplEnum {
		SCALA_O2O_HASH(scala.collection.mutable.HashMap::new), //
		SCALA_O2O_TREE(() -> new scala.collection.mutable.TreeMap<String, Integer>(//
				scala.math.Ordering.String$.MODULE$)), //
		SCALA_O2O_LINKED(scala.collection.mutable.LinkedHashMap::new), //
		;

		public final Supplier<Map<String, Integer>> maker;

		private ImplEnum(Supplier<Map<String, Integer>> maker) {
			this.maker = maker;
		}
	}

	@Override
	protected Map<String, Integer> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected int size(Map<String, Integer> map) {
		return map.size();
	}

	@Override
	protected void count(Map<String, Integer> map, String object) {
		// Avoid ambiguity:
		Option<Integer> old = ((scala.collection.Map<String, Integer>) map).get(object);
		map.put(object, old.isDefined() ? old.get() + 1 : 1);
	}
}
