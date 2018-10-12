package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import com.koloboke.collect.set.IntSet;

public enum KolobokeIntSetFact {
	KOLOBOKE_I_HASH(com.koloboke.collect.set.hash.HashIntSets::newMutableSet), //
	KOLOBOKE_I_QHASH(KolobokeQHash.IntSets::newMutableSet), //
	;

	public final Supplier<IntSet> maker;

	private KolobokeIntSetFact(Supplier<IntSet> maker) {
		this.maker = maker;
	}
}