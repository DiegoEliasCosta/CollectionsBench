package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import org.agrona.collections.IntHashSet;

public enum AgronaIntSetFact {
	AGRONA_I_HASH(() -> new IntHashSet(-1)), //
	;

	public final Supplier<IntHashSet> maker;

	private AgronaIntSetFact(Supplier<IntHashSet> maker) {
		this.maker = maker;
	}
}