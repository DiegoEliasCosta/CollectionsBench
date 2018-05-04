package de.heidelberg.pvs.container_bench.factories;

import net.openhft.koloboke.collect.map.hash.HashObjIntMap;
import net.openhft.koloboke.collect.map.hash.HashObjObjMap;

public class KolobokeQHash {
	public static class ObjObjMaps {
		private static final net.openhft.koloboke.collect.map.hash.HashObjObjMapFactory<Object, Object> FACTORY = new net.openhft.koloboke.collect.impl.hash.QHashParallelKVObjObjMapFactoryImpl<>();

		public static final <K, V> HashObjObjMap<K, V> newMutableMap() {
			return FACTORY.newMutableMap();
		}
	}

	public static class ObjIntMaps {
		private static final net.openhft.koloboke.collect.map.hash.HashObjIntMapFactory<Object> FACTORY = new net.openhft.koloboke.collect.impl.hash.QHashSeparateKVObjIntMapFactoryImpl<>();

		public static final <K> HashObjIntMap<K> newMutableMap() {
			return FACTORY.newMutableMap();
		}
	}
}
