package de.heidelberg.pvs.container_bench.wordcount;

import java.util.Map;
import java.util.function.Supplier;

import org.openjdk.jmh.annotations.Param;

public abstract class AbstractJDKCompatible extends AbstractWordcountBenchmark<Map<Object, Integer>> {
	@Param
	public ImplEnum impl;

	private static final net.openhft.koloboke.collect.map.hash.HashObjObjMapFactory<Object, Object> KOLOBOKEQ = new net.openhft.koloboke.collect.impl.hash.QHashParallelKVObjObjMapFactoryImpl<>();

	public static enum ImplEnum {
		JDK_O2O_HASH(java.util.HashMap::new), //
		JDK_O2O_LINKEDHASH(java.util.LinkedHashMap::new), //
		JDK_O2O_TREE(java.util.TreeMap::new), //
		FASTUTIL_O2O_HASH(it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap::new), //
		FASTUTIL_O2O_LINKEDHASH(it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap::new), //
		FASTUTIL_O2O_AVL(it.unimi.dsi.fastutil.objects.Object2ObjectAVLTreeMap::new), //
		FASTUTIL_O2O_RB(it.unimi.dsi.fastutil.objects.Object2ObjectRBTreeMap::new), //
		FASTUTIL_O2I_HASH(it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap::new), //
		FASTUTIL_O2I_LINKEDHASH(it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap::new), //
		FASTUTIL_O2I_AVL(it.unimi.dsi.fastutil.objects.Object2IntAVLTreeMap::new), //
		FASTUTIL_O2I_RB(it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap::new), //
		TROVE_O2O_HASH(gnu.trove.map.hash.THashMap::new), //
		KOLOBOKE_O2O_HASH(net.openhft.koloboke.collect.map.hash.HashObjObjMaps::newMutableMap), //
		KOLOBOKE_O2I_HASH(net.openhft.koloboke.collect.map.hash.HashObjIntMaps::newMutableMap), //
		KOLOBOKE_O2O_QHASH(() -> KOLOBOKEQ.newMutableMap()), //
		KOLOBOKE_O2I_QHASH(() -> KOLOBOKEQ.newMutableMap()), //
		ECLIPSE_O2O_HASH(org.eclipse.collections.impl.map.mutable.UnifiedMap::new), //
		ECLIPSE_O2O_TREE(org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap::new), //
		APACHE_O2O_HASH(org.apache.commons.collections4.map.HashedMap::new), //
		APACHE_O2O_LINKEDHASH(org.apache.commons.collections4.map.LinkedMap::new), //
		MAHOUT_O2O_HASH(org.apache.mahout.math.map.OpenHashMap::new), //
		JAVOLUTION_HASH(javolution.util.FastMap::new), //
		JAVOLUTION_SORTED(javolution.util.FastSortedMap::new), //
		// These will be very slow:
		FASTUTIL_O2O_ARRAY(it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap::new), //
		FASTUTIL_O2I_ARRAY(it.unimi.dsi.fastutil.objects.Object2IntArrayMap::new), //
		GOOGLE_O2O_ARRAY(com.google.api.client.util.ArrayMap::new), //
		CORENLP_ARRAY(edu.stanford.nlp.util.ArrayMap::new); //
		;

		public final Supplier<Map<Object, Integer>> maker;

		private ImplEnum(Supplier<Map<Object, Integer>> maker) {
			this.maker = maker;
		}
	}

	@Override
	protected Map<Object, Integer> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected int size(Map<Object, Integer> map) {
		return map.size();
	}
}
