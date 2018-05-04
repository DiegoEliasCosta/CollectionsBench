package de.heidelberg.pvs.container_bench.wordcount;

import org.openjdk.jmh.annotations.Param;

import net.openhft.koloboke.collect.map.hash.HashObjIntMap;
import net.openhft.koloboke.collect.map.hash.HashObjIntMaps;

public class KolobokeIntegerAddTo extends AbstractWordcountBenchmark<HashObjIntMap<Object>> {
	@Param({ "KOLOBOKE_O2I_HASH" })
	public String impl;

	@Override
	protected HashObjIntMap<Object> makeMap() {
		return HashObjIntMaps.newMutableMap();
	}

	@Override
	protected int size(HashObjIntMap<Object> map) {
		return map.size();
	}

	@Override
	protected void count(HashObjIntMap<Object> map, String object) {
		map.addValue(object, 1);
	}
}
