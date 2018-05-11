package de.heidelberg.pvs.container_bench.hppc.maps;

import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.ObjectObjectMap;

import de.heidelberg.pvs.container_bench.abstracts.hppc.AbstractHPPCMapBench;
import de.heidelberg.pvs.container_bench.factories.HPPCMap2IntFact;
import de.heidelberg.pvs.container_bench.factories.HPPCMapFact;

public class HPPCMapBench extends AbstractHPPCMapBench<Object, Integer> {

	@Param
	HPPCMapFact impl;

	@Override
	protected ObjectObjectMap<Object, Integer> getNewMap() {
		return impl.maker.get();
	}
	
}
