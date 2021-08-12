package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.eclipse.collections.impl.factory.primitive.ObjectIntMaps;

public enum EclipseMap2IntFact {
	ECLIPSE_O2I_HASH;

	public final Supplier<MutableObjectIntMap<Object>> maker = ObjectIntMaps.mutable::empty;
}
