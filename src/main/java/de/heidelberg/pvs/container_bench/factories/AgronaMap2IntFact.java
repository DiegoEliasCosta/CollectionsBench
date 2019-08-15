package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import org.agrona.collections.Int2IntHashMap;

public enum AgronaMap2IntFact {
	
	AGRONA_I_HASH(() -> new Int2IntHashMap(-1)), //
	;

	public final Supplier<Int2IntHashMap> maker;

	private AgronaMap2IntFact(Supplier<Int2IntHashMap> maker) {
		this.maker = maker;
	}
}