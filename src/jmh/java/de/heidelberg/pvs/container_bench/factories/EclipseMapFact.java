package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import org.eclipse.collections.api.map.MutableMapIterable;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;

public enum EclipseMapFact {
	ECLIPSE_O2O_HASH(UnifiedMap::new), //
	ECLIPSE_O2O_TREE(TreeSortedMap::new), //
	;

	public final Supplier<MutableMapIterable<Object, Integer>> maker;

	private EclipseMapFact(Supplier<MutableMapIterable<Object, Integer>> maker) {
		this.maker = maker;
	}
}