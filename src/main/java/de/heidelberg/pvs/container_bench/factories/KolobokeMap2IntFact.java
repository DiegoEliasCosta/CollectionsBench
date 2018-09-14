package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import com.koloboke.collect.map.hash.HashObjIntMap;

public enum KolobokeMap2IntFact {
	KOLOBOKE_O2I_HASH(com.koloboke.collect.map.hash.HashObjIntMaps::newMutableMap), //
	KOLOBOKE_O2I_QHASH(KolobokeQHash.ObjIntMaps::newMutableMap), //
	;

	public final Supplier<HashObjIntMap<Object>> maker;

	private KolobokeMap2IntFact(Supplier<HashObjIntMap<Object>> maker) {
		this.maker = maker;
	}
}