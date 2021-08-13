package container.factories;

import java.util.function.Supplier;

import it.unimi.dsi.fastutil.objects.Object2IntMap;

public enum FastutilMap2IntFact {
	FASTUTIL_O2I_HASH(it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap::new), //
	FASTUTIL_O2I_LINKEDHASH(it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap::new), //
	FASTUTIL_O2I_AVL(it.unimi.dsi.fastutil.objects.Object2IntAVLTreeMap::new), //
	FASTUTIL_O2I_RB(it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap::new), //
	FASTUTIL_O2I_ARRAY(it.unimi.dsi.fastutil.objects.Object2IntArrayMap::new), //
	;

	public final Supplier<Object2IntMap<Object>> maker;

	private FastutilMap2IntFact(Supplier<Object2IntMap<Object>> maker) {
		this.maker = maker;
	}
}