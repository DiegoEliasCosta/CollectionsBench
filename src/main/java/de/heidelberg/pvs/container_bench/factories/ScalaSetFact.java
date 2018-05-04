package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import scala.collection.mutable.Set;

public enum ScalaSetFact {
	SCALA_HASH(scala.collection.mutable.HashSet::new), //
	SCALA_TREE(() -> new scala.collection.mutable.TreeSet<String>(scala.math.Ordering.String$.MODULE$)), //
	SCALA_LINKED(scala.collection.mutable.LinkedHashSet::new), //
	;

	public final Supplier<Set<String>> maker;

	private ScalaSetFact(Supplier<Set<String>> maker) {
		this.maker = maker;
	}
}