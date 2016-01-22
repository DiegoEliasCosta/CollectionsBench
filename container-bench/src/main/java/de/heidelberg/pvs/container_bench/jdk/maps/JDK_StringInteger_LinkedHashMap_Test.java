package de.heidelberg.pvs.container_bench.jdk.maps;

import java.util.LinkedHashMap;
import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;

public class JDK_StringInteger_LinkedHashMap_Test extends AbstractJDKMapTest<String, Integer>{

	@Override
	protected Map<String, Integer> getNewMap(int size, int range) {
		return new LinkedHashMap<String, Integer>();
	}


	@Override
	protected Map<String, Integer> copyMap(Map<String, Integer> fullMap2) {
		return new LinkedHashMap<>();
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
