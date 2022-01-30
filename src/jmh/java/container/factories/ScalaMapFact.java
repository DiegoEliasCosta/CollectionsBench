package container.factories;

import java.util.function.Supplier;

import scala.collection.mutable.Map;

public enum ScalaMapFact {
	SCALA_O2O_HASH(scala.collection.mutable.HashMap::new), //
	@SuppressWarnings({ "unchecked", "rawtypes" })
	SCALA_O2O_TREE(() -> (scala.collection.mutable.TreeMap<?, Integer>) new scala.collection.mutable.TreeMap(//
			scala.math.Ordering.String$.MODULE$)), //
	SCALA_O2O_LINKED(scala.collection.mutable.LinkedHashMap::new), //
	;

	public final Supplier<Map<?, Integer>> maker;

	private ScalaMapFact(Supplier<Map<?, Integer>> maker) {
		this.maker = maker;
	}
}