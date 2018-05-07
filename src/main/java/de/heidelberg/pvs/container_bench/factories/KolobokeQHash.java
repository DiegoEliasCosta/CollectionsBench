package de.heidelberg.pvs.container_bench.factories;

import net.openhft.koloboke.collect.map.hash.HashObjIntMap;
import net.openhft.koloboke.collect.map.hash.HashObjObjMap;
import net.openhft.koloboke.collect.set.hash.HashIntSet;
import net.openhft.koloboke.collect.set.hash.HashObjSet;

public class KolobokeQHash {
	public static class ObjObjMaps {
		private static final net.openhft.koloboke.collect.map.hash.HashObjObjMapFactory<Object, Object> FACTORY = new net.openhft.koloboke.collect.impl.hash.QHashParallelKVObjObjMapFactoryImpl<>();

		public static final <K, V> HashObjObjMap<K, V> newMutableMap() {
			return FACTORY.newMutableMap();
		}
	}

	public static class ObjSets {
		private static final net.openhft.koloboke.collect.set.hash.HashObjSetFactory<Object> FACTORY = new net.openhft.koloboke.collect.impl.hash.QHashObjSetFactoryImpl<>();

		public static final <K> HashObjSet<K> newMutableSet() {
			return FACTORY.newMutableSet();
		}
	}

	public static class IntSets {
		private static final net.openhft.koloboke.collect.set.hash.HashIntSetFactory FACTORY = new net.openhft.koloboke.collect.impl.hash.QHashIntSetFactoryImpl();

		public static final HashIntSet newMutableSet() {
			return FACTORY.newMutableSet();
		}
	}

	public static class ObjIntMaps {
		private static final net.openhft.koloboke.collect.map.hash.HashObjIntMapFactory<Object> FACTORY = new net.openhft.koloboke.collect.impl.hash.QHashSeparateKVObjIntMapFactoryImpl<>();

		public static final <K> HashObjIntMap<K> newMutableMap() {
			return FACTORY.newMutableMap();
		}
	}
}
