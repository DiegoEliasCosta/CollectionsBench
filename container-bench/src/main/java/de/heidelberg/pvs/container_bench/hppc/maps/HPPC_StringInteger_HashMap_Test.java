package de.heidelberg.pvs.container_bench.hppc.maps;

import com.carrotsearch.hppc.ObjectObjectHashMap;

import de.heidelberg.pvs.container_bench.abstracts.hppc.AbstractHPPCMapTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;

public class HPPC_StringInteger_HashMap_Test extends AbstractHPPCMapTest<String, Integer>{

	@Override
	protected ObjectObjectHashMap<String, Integer> getNewMap(int size, int range) {
		return new ObjectObjectHashMap<>();
	}

	@Override
	protected ObjectObjectHashMap<String, Integer> copyMap(ObjectObjectHashMap<String, Integer> fullMap2) {
		return new ObjectObjectHashMap<>(fullMap2);
	}

	@Override
	protected RandomGenerator<String> instantiateRandomKeyGenerator() {
		return new StringRandomGenerator();
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomValueGenerator() {
		return new IntegerRandomGenerator();
	}

	


}
