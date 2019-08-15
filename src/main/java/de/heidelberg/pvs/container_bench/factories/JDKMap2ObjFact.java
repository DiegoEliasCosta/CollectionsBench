package de.heidelberg.pvs.container_bench.factories;

import java.util.Map;
import java.util.function.Supplier;

public enum JDKMap2ObjFact {
	

	JDK_O2O_HASH(java.util.HashMap::new), //
	JDK_O2O_LINKEDHASH(java.util.LinkedHashMap::new), //
	JDK_O2O_TREE(java.util.TreeMap::new), //
	JDK_O2O_HASHTABLE(java.util.Hashtable::new), //

	KOLOBOKE_O2O_HASH(com.koloboke.collect.map.hash.HashObjObjMaps::newMutableMap), //
	KOLOBOKE_O2O_QHASH(KolobokeQHash.ObjObjMaps::newMutableMap), //

	FASTUTIL_O2O_HASH(it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap::new), //
	FASTUTIL_O2O_LINKEDHASH(it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap::new), //
	FASTUTIL_O2O_AVL(it.unimi.dsi.fastutil.objects.Object2ObjectAVLTreeMap::new), //
	FASTUTIL_O2O_RB(it.unimi.dsi.fastutil.objects.Object2ObjectRBTreeMap::new), //
	FASTUTIL_O2O_ARRAY(it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap::new, 1000000), //

	TROVE_O2O_HASH(gnu.trove.map.hash.THashMap::new), //

	ECLIPSE_O2O_HASH(org.eclipse.collections.impl.map.mutable.UnifiedMap::new), //
	ECLIPSE_O2O_TREE(org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap::new), //

	APACHE_O2O_HASH(org.apache.commons.collections4.map.HashedMap::new), //
	APACHE_O2O_LINKEDHASH(org.apache.commons.collections4.map.LinkedMap::new), //

	MAHOUT_O2O_HASH(org.apache.mahout.math.map.OpenHashMap::new), //

	JAVOLUTION_HASH(javolution.util.FastMap::new), //
	JAVOLUTION_SORTED(javolution.util.FastSortedMap::new, 1000000), //

	AGRONA_O2O_HASH(org.agrona.collections.Object2ObjectHashMap::new), //
	
	GOOGLE_O2O_ARRAY(com.google.api.client.util.ArrayMap::new, 1000000), //
	CORENLP_ARRAY(edu.stanford.nlp.util.ArrayMap::new, 1000000); //
	;

	public final Supplier<Map<Object, Object>> maker;

	public final int maxsize;

	private JDKMap2ObjFact(Supplier<Map<Object, Object>> maker) {
		this(maker, Integer.MAX_VALUE);
	}

	private JDKMap2ObjFact(Supplier<Map<Object, Object>> maker, int maxsize) {
		this.maker = maker;
		this.maxsize = maxsize;
	}
}
