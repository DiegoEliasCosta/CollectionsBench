package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import org.apache.mahout.math.set.OpenIntHashSet;

public enum MahoutIntSetFact {
	MAHOUT_I_HASH(OpenIntHashSet::new), //
	;

	public final Supplier<OpenIntHashSet> maker;

	private MahoutIntSetFact(Supplier<OpenIntHashSet> maker) {
		this.maker = maker;
	}
}