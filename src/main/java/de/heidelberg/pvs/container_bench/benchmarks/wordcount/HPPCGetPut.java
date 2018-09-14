package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.ObjectObjectMap;

import de.heidelberg.pvs.container_bench.factories.HPPCMapFact;

/**
 * Adapter using the HPPC equivalents of the JCF API
 * 
 * @author Erich Schubert
 */
public class HPPCGetPut extends AbstractWordcountBenchmark<ObjectObjectMap<Object, Integer>> {
	@Param
	public HPPCMapFact impl;

	@Override
	protected ObjectObjectMap<Object, Integer> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected void count(ObjectObjectMap<Object, Integer> map, String object) {
		Integer old = map.get(object);
		map.put(object, old != null ? old + 1 : 1);
	}

	@Override
	protected int size(ObjectObjectMap<Object, Integer> map) {
		return map.size();
	}
}