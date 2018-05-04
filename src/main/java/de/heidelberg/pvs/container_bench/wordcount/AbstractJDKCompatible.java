package de.heidelberg.pvs.container_bench.wordcount;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Supplier;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.collections4.map.LinkedMap;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;
import org.openjdk.jmh.annotations.Param;

import gnu.trove.map.hash.THashMap;
import it.unimi.dsi.fastutil.objects.Object2IntAVLTreeMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectAVLTreeMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectRBTreeMap;
import net.openhft.koloboke.collect.map.hash.HashObjIntMaps;
import net.openhft.koloboke.collect.map.hash.HashObjObjMaps;

public abstract class AbstractJDKCompatible extends AbstractWordcountBenchmark<Map<Object, Integer>> {
	@Param
	public ImplEnum impl;
	
	public static enum ImplEnum {
		JDK_O2O_HASH(HashMap::new), //
		JDK_O2O_LINKEDHASH(LinkedHashMap::new), //
		JDK_O2O_TREE(TreeMap::new), //
		FASTUTIL_O2O_HASH(Object2ObjectOpenHashMap::new), //
		FASTUTIL_O2O_AVL(Object2ObjectAVLTreeMap::new), //
		FASTUTIL_O2O_RB(Object2ObjectRBTreeMap::new), //
		// FASTUTIL_O2O_ARRAY(Object2ObjectArrayMap::new), // too slow
		FASTUTIL_O2I_HASH(Object2IntOpenHashMap::new), //
		FASTUTIL_O2I_AVL(Object2IntAVLTreeMap::new), //
		FASTUTIL_O2I_RB(Object2IntRBTreeMap::new), //
		// FASTUTIL_O2I_ARRAY(Object2IntArrayMap::new), // too slow
		TROVE_O2O_HASH(THashMap::new), //
		KOLOBOKE_O2O_HASH(HashObjObjMaps::newMutableMap), //
		KOLOBOKE_O2I_HASH(HashObjIntMaps::newMutableMap), //
		ECLIPSE_O2O_HASH(UnifiedMap::new), //
		ECLIPSE_O2O_TREE(TreeSortedMap::new), //
		APACHE_O2O_HASH(HashedMap::new), //
		APACHE_O2O_LINKEDHASH(LinkedMap::new), //
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
