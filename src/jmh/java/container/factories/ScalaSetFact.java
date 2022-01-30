package container.factories;

import java.util.function.Supplier;

import scala.collection.mutable.Set;

public enum ScalaSetFact {
	SCALA_HASH(scala.collection.mutable.HashSet::new), //
	@SuppressWarnings({ "rawtypes", "unchecked" })
	SCALA_TREE(() -> (scala.collection.mutable.Set<?>) new scala.collection.mutable.TreeSet(
			scala.math.Ordering.String$.MODULE$)), //
	SCALA_LINKED(scala.collection.mutable.LinkedHashSet::new), //
	;

	public final Supplier<Set<?>> maker;

	private ScalaSetFact(Supplier<Set<?>> maker) {
		this.maker = maker;
	}
}