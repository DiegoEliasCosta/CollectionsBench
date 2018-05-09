package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import com.carrotsearch.hppc.ObjectIntHashMap;
import com.carrotsearch.hppc.ObjectIntMap;
import com.carrotsearch.hppc.ObjectIntScatterMap;

public enum HPPCMap2IntFact {
	HPPC_O2I_HASH(ObjectIntHashMap::new), //
	HPPC_O2I_SCATTER(ObjectIntScatterMap::new), //
	;

	public final Supplier<ObjectIntMap<Object>> maker;

	private HPPCMap2IntFact(Supplier<ObjectIntMap<Object>> maker) {
		this.maker = maker;
	}
}