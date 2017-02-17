package de.heidelberg.pvs.container_bench.hppc.maps;

import com.carrotsearch.hppc.ObjectObjectHashMap;

import de.heidelberg.pvs.container_bench.abstracts.hppc.AbstractHPPCMapTest;

public class HPPC_LongInteger_HashMap_Test extends AbstractHPPCMapTest<Long, Integer>{

	@Override
	protected ObjectObjectHashMap<Long, Integer> getNewMap(int size, int range) {
		return new ObjectObjectHashMap<>();
	}

	@Override
	protected ObjectObjectHashMap<Long, Integer> copyMap(ObjectObjectHashMap<Long, Integer> fullMap2) {
		return new ObjectObjectHashMap<>(fullMap2);
	}

}
