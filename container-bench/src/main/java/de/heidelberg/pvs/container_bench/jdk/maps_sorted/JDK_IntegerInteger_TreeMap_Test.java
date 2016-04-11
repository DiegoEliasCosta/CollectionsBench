package de.heidelberg.pvs.container_bench.jdk.maps_sorted;

import java.util.Map;
import java.util.TreeMap;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_IntegerInteger_TreeMap_Test extends AbstractJDKMapTest<Integer, Integer>{

	@Override
	protected Map<Integer, Integer> getNewMap(int size, int range) {
		return new TreeMap<Integer, Integer>();
	}


	@Override
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		return new TreeMap<Integer, Integer>(fullMap2);
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
