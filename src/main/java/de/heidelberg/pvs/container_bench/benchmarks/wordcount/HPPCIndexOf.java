package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.ObjectObjectMap;

import de.heidelberg.pvs.container_bench.factories.HPPCMapFact;

/**
 * Adapter using the index-based operations
 * 
 * @author Erich Schubert
 */
public class HPPCIndexOf extends AbstractWordcountBenchmark<ObjectObjectMap<Object, Integer>> {
	@Param
	public HPPCMapFact impl;

	@Override
	protected ObjectObjectMap<Object, Integer> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected void count(ObjectObjectMap<Object, Integer> map, String object) {
		int idx = map.indexOf(object);
		if (idx >= 0) {
			map.indexReplace(idx, map.indexGet(idx) + 1);
		} else {
			map.indexInsert(idx, object, 1);
		}
	}

	@Override
	protected int size(ObjectObjectMap<Object, Integer> map) {
		return map.size();
	}
}