package de.heidelberg.pvs.container_bench.wordaddremove;

import scala.collection.mutable.Set;
import java.util.function.Supplier;

import org.openjdk.jmh.annotations.Param;

public class ScalaGetPut extends AbstractWordAddRemoveBenchmark<Set<String>> {
	@Param
	public ImplEnum impl;

	public static enum ImplEnum {
		SCALA_HASH(scala.collection.mutable.HashSet::new), //
		SCALA_TREE(() -> new scala.collection.mutable.TreeSet<String>(scala.math.Ordering.String$.MODULE$)), //
		SCALA_LINKED(scala.collection.mutable.LinkedHashSet::new), //
		;

		public final Supplier<Set<String>> maker;

		private ImplEnum(Supplier<Set<String>> maker) {
			this.maker = maker;
		}
	}

	@Override
	protected Set<String> makeSet() {
		return impl.maker.get();
	}

	@Override
	protected int size(Set<String> set) {
		return set.size();
	}

	@Override
	protected void add(Set<String> map, String object) {
		map.add(object);
	}

	@Override
	protected void remove(Set<String> map, String object) {
		map.remove(object);
	}
}
