package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import it.unimi.dsi.fastutil.objects.Object2IntMap;

public enum FastutilMap2IntFact {
	FASTUTIL_O2I_HASH(it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap::new), //
	FASTUTIL_O2I_LINKEDHASH(it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap::new), //
	FASTUTIL_O2I_AVL(it.unimi.dsi.fastutil.objects.Object2IntAVLTreeMap::new), //
	FASTUTIL_O2I_RB(it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap::new), //
	FASTUTIL_O2I_ARRAY(it.unimi.dsi.fastutil.objects.Object2IntArrayMap::new, 1000000), //
	;

	public final Supplier<Object2IntMap<Object>> maker;

	public final int maxsize;

	private FastutilMap2IntFact(Supplier<Object2IntMap<Object>> maker) {
		this(maker, Integer.MAX_VALUE);
	}

	private FastutilMap2IntFact(Supplier<Object2IntMap<Object>> maker, int maxsize) {
		this.maker = maker;
		this.maxsize = maxsize;
	}
}