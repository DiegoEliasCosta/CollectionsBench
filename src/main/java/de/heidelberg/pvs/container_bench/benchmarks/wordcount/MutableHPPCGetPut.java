package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.ObjectObjectMap;

import de.heidelberg.pvs.container_bench.factories.HPPCMapFact;

/**
 * Adapter using the HPPC equivalents of the JCF API
 * 
 * @author Erich Schubert
 */
public class MutableHPPCGetPut extends AbstractWordcountBenchmark<ObjectObjectMap<Object, MutableInteger>> {
	@Param
	public HPPCMapFact impl;

	@Override
	protected ObjectObjectMap<Object, MutableInteger> makeMap() {
		return (ObjectObjectMap<Object, MutableInteger>) (ObjectObjectMap<?, ?>) impl.maker.get();
	}

	@Override
	protected void count(ObjectObjectMap<Object, MutableInteger> map, String object) {
		final MutableInteger old = map.get(object);
		if (old != null) {
			old.v++;
		} else {
			map.put(object, new MutableInteger(1));
		}
	}

	@Override
	protected int size(ObjectObjectMap<Object, MutableInteger> map) {
		return map.size();
	}
}
