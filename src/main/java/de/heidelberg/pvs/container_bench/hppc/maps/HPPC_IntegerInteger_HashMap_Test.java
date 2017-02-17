package de.heidelberg.pvs.container_bench.hppc.maps;

import com.carrotsearch.hppc.ObjectObjectHashMap;

import de.heidelberg.pvs.container_bench.abstracts.hppc.AbstractHPPCMapTest;

public class HPPC_IntegerInteger_HashMap_Test extends AbstractHPPCMapTest<Integer, Integer>{

	@Override
	protected ObjectObjectHashMap<Integer, Integer> getNewMap(int size, int range) {
		return new ObjectObjectHashMap<>();
	}

	@Override
	protected ObjectObjectHashMap<Integer, Integer> copyMap(ObjectObjectHashMap<Integer, Integer> fullMap2) {
		return new ObjectObjectHashMap<>(fullMap2);
	}

}
