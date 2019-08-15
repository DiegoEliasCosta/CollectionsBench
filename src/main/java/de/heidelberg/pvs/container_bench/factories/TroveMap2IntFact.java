package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.hash.TObjectIntHashMap;

public enum TroveMap2IntFact {
	TROVE_O2I_HASH; //

	public final Supplier<TObjectIntMap<Object>> maker = TObjectIntHashMap::new;
}
