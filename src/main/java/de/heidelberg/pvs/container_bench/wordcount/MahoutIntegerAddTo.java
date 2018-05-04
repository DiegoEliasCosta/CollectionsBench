package de.heidelberg.pvs.container_bench.wordcount;

import org.apache.mahout.math.map.OpenObjectIntHashMap;
import org.openjdk.jmh.annotations.Param;

public class MahoutIntegerAddTo extends AbstractWordcountBenchmark<OpenObjectIntHashMap<Object>> {
	@Param({ "MAHOUT_O2I_HASH" })
	public String impl;

	@Override
	protected OpenObjectIntHashMap<Object> makeMap() {
		return new OpenObjectIntHashMap<Object>();
	}

	@Override
	protected int size(OpenObjectIntHashMap<Object> map) {
		return map.size();
	}

	@Override
	protected void count(OpenObjectIntHashMap<Object> map, String object) {
		map.adjustOrPutValue(object, 1, 1);
	}
}
