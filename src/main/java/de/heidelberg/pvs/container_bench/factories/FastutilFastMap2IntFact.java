package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Function;
import java.util.function.Supplier;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap.FastEntrySet;

/**
 * Faster iteration API of fastutil, unfortunately not available for the AVL and
 * RB tree maps. Because of this, we need some ugly casts in here.
 * 
 * @author Erich Schubert
 */
public enum FastutilFastMap2IntFact {
	FASTUTIL_O2I_HASH(it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap::new,
			x -> ((it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap<Object>) x).object2IntEntrySet()), //
	FASTUTIL_O2I_LINKEDHASH(it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap::new,
			x -> ((it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap<Object>) x).object2IntEntrySet()), //
	FASTUTIL_O2I_ARRAY(it.unimi.dsi.fastutil.objects.Object2IntArrayMap::new,
			x -> ((it.unimi.dsi.fastutil.objects.Object2IntArrayMap<Object>) x).object2IntEntrySet()), //
	;

	public final Supplier<Object2IntMap<Object>> maker;
	public final Function<Object2IntMap<Object>, FastEntrySet<Object>> fastEntrySet;

	private FastutilFastMap2IntFact(Supplier<Object2IntMap<Object>> maker,
			Function<Object2IntMap<Object>, FastEntrySet<Object>> fast) {
		this.maker = maker;
		this.fastEntrySet = fast;
	}
}