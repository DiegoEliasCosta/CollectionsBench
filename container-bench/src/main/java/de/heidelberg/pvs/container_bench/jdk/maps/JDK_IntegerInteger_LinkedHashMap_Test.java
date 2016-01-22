package de.heidelberg.pvs.container_bench.jdk.maps;

import java.util.LinkedHashMap;
import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_IntegerInteger_LinkedHashMap_Test extends AbstractJDKMapTest<Integer, Integer>{

	@Override
	protected Map<Integer, Integer> getNewMap(int size, int range) {
		return new LinkedHashMap<Integer, Integer>();
	}


	@Override
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		return new LinkedHashMap<>();
	}


	@Override
	protected RandomGenerator<Integer> instantiateRandomKeyGenerator() {
		return new IntegerRandomGenerator();
	}


	@Override
	protected RandomGenerator<Integer> instantiateRandomValueGenerator() {
		return new IntegerRandomGenerator();
	}

}
