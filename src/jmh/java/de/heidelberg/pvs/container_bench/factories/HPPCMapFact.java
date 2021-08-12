package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import com.carrotsearch.hppc.ObjectObjectHashMap;
import com.carrotsearch.hppc.ObjectObjectMap;
import com.carrotsearch.hppc.ObjectObjectWormMap;

public enum HPPCMapFact {
	HPPC_O2O_HASH(ObjectObjectHashMap::new), //
	HPPC_O2O_SCATTER(ObjectObjectWormMap::new), //
	;

	public final Supplier<ObjectObjectMap<Object, Integer>> maker;

	private HPPCMapFact(Supplier<ObjectObjectMap<Object, Integer>> maker) {
		this.maker = maker;
	}
}