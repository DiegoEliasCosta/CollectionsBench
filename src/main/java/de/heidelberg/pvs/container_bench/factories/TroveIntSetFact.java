package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import gnu.trove.set.TIntSet;
import gnu.trove.set.hash.TIntHashSet;

public enum TroveIntSetFact {
	TROVE_I_HASH; //

	public final Supplier<TIntSet> maker = TIntHashSet::new;
}
