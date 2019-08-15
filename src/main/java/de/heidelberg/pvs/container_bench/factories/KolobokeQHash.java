package de.heidelberg.pvs.container_bench.factories;

import com.koloboke.collect.map.hash.HashObjIntMap;
import com.koloboke.collect.map.hash.HashObjObjMap;
import com.koloboke.collect.set.hash.HashIntSet;
import com.koloboke.collect.set.hash.HashObjSet;

public class KolobokeQHash {
	public static class ObjObjMaps {
		private static final com.koloboke.collect.map.hash.HashObjObjMapFactory<Object, Object> FACTORY = new com.koloboke.collect.impl.hash.QHashParallelKVObjObjMapFactoryImpl<>(); //

		public static final <K, V> HashObjObjMap<K, V> newMutableMap() {
			return FACTORY.newMutableMap();
		}
	}

	public static class ObjSets {
		private static final com.koloboke.collect.set.hash.HashObjSetFactory<Object> FACTORY = new com.koloboke.collect.impl.hash.QHashObjSetFactoryImpl<>(); //

		public static final <K> HashObjSet<K> newMutableSet() {
			return FACTORY.newMutableSet();
		}
	}

	public static class IntSets {
		private static final com.koloboke.collect.set.hash.HashIntSetFactory FACTORY = new com.koloboke.collect.impl.hash.QHashIntSetFactoryImpl(); //

		public static final HashIntSet newMutableSet() {
			return FACTORY.newMutableSet();
		}
	}

	public static class ObjIntMaps {
		private static final com.koloboke.collect.map.hash.HashObjIntMapFactory<Object> FACTORY = new com.koloboke.collect.impl.hash.QHashSeparateKVObjIntMapFactoryImpl<>(); //

		public static final <K> HashObjIntMap<K> newMutableMap() {
			return FACTORY.newMutableMap();
		}
	}
}
