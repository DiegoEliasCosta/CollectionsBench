package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import it.unimi.dsi.fastutil.ints.IntSet;

public enum FastutilIntSetFact {
	FASTUTIL_I_HASH(it.unimi.dsi.fastutil.ints.IntOpenHashSet::new), //
	FASTUTIL_I_AVL(it.unimi.dsi.fastutil.ints.IntAVLTreeSet::new), //
	FASTUTIL_I_RB(it.unimi.dsi.fastutil.ints.IntRBTreeSet::new), //
	FASTUTIL_I_ARRAY(it.unimi.dsi.fastutil.ints.IntArraySet::new), //
	;

	public final Supplier<IntSet> maker;

	private FastutilIntSetFact(Supplier<IntSet> maker) {
		this.maker = maker;
	}
}