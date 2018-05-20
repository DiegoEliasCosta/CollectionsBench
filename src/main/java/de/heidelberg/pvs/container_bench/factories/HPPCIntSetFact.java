package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import com.carrotsearch.hppc.IntHashSet;
import com.carrotsearch.hppc.IntScatterSet;


public enum HPPCIntSetFact {
	HPPC_I_HASH(IntHashSet::new), //
	HPPC_I_SCATTER(IntScatterSet::new), //
	;

	public final Supplier<IntHashSet> maker;
	
	private HPPCIntSetFact(Supplier<IntHashSet> maker) {
		this.maker = maker;
	}
}