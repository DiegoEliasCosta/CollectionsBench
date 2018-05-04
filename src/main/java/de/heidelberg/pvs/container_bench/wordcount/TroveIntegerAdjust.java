package de.heidelberg.pvs.container_bench.wordcount;

import org.openjdk.jmh.annotations.Param;

import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.hash.TObjectIntHashMap;

public class TroveIntegerAdjust extends AbstractWordcountBenchmark<TObjectIntMap<Object>> {
	@Param({ "TROVE_O2I_HASH" })
	public String impl;

	@Override
	protected TObjectIntMap<Object> makeMap() {
		return new TObjectIntHashMap<Object>();
	}

	@Override
	protected int size(TObjectIntMap<Object> map) {
		return map.size();
	}

	@Override
	protected void count(TObjectIntMap<Object> map, String object) {
		map.adjustOrPutValue(object, 1, 1);
	}
}
