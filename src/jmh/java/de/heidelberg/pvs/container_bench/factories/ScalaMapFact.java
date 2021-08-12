package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import scala.collection.mutable.Map;

public enum ScalaMapFact {
	SCALA_O2O_HASH(scala.collection.mutable.HashMap::new), //
	SCALA_O2O_TREE(() -> new scala.collection.mutable.TreeMap<String, Integer>(//
			scala.math.Ordering.String$.MODULE$)), //
	SCALA_O2O_LINKED(scala.collection.mutable.LinkedHashMap::new), //
	;

	public final Supplier<Map<String, Integer>> maker;

	private ScalaMapFact(Supplier<Map<String, Integer>> maker) {
		this.maker = maker;
	}
}