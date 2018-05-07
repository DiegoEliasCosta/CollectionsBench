package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.impl.factory.primitive.IntSets;

public enum EclipseIntSetFact {
	ECLIPSE_I_HASH(IntSets.mutable::empty), //
	;

	public final Supplier<MutableIntSet> maker;

	private EclipseIntSetFact(Supplier<MutableIntSet> maker) {
		this.maker = maker;
	}
}