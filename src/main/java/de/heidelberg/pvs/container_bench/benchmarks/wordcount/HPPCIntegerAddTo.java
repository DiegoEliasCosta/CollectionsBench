package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.ObjectIntMap;

import de.heidelberg.pvs.container_bench.factories.HPPCMap2IntFact;

/**
 * Adapter using the HPPC primitive map
 * 
 * @author Erich Schubert
 */
public class HPPCIntegerAddTo extends AbstractWordcountBenchmark<ObjectIntMap<Object>> {
	@Param
	public HPPCMap2IntFact impl;

	@Override
	protected ObjectIntMap<Object> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected void count(ObjectIntMap<Object> map, String object) {
		map.addTo(object, 1);
	}

	@Override
	protected int size(ObjectIntMap<Object> map) {
		return map.size();
	}
}