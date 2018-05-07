package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import com.carrotsearch.hppc.IntHashSet;
import com.carrotsearch.hppc.IntScatterSet;
import com.carrotsearch.hppc.IntSet;

public enum HPPCIntSetFact {
	HPPC_I_HASH(IntHashSet::new), //
	HPPC_I_SCATTER(IntScatterSet::new), //
	;

	public final Supplier<IntSet> maker;

	private HPPCIntSetFact(Supplier<IntSet> maker) {
		this.maker = maker;
	}
}