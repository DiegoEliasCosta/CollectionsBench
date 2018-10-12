package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.ObjectObjectMap;

import de.heidelberg.pvs.container_bench.factories.HPPCMapFact;

/**
 * Adapter using the index-based operations
 * 
 * @author Erich Schubert
 */
public class MutableHPPCIndexOf extends AbstractWordcountBenchmark<ObjectObjectMap<Object, MutableInteger>> {
	@Param
	public HPPCMapFact impl;

	@Override
	protected ObjectObjectMap<Object, MutableInteger> makeMap() {
		return (ObjectObjectMap<Object, MutableInteger>) (ObjectObjectMap<?, ?>) impl.maker.get();
	}

	@Override
	protected void count(ObjectObjectMap<Object, MutableInteger> map, String object) {
		int idx = map.indexOf(object);
		if (idx >= 0) {
			map.indexGet(idx).v += 1;
		} else {
			map.indexInsert(idx, object, new MutableInteger(1));
		}
	}

	@Override
	protected int size(ObjectObjectMap<Object, MutableInteger> map) {
		return map.size();
	}
}
