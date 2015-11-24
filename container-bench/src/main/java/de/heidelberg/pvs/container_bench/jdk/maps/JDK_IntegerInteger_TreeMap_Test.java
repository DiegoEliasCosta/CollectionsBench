package de.heidelberg.pvs.container_bench.jdk.maps;

import java.util.Map;
import java.util.TreeMap;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;

public class JDK_IntegerInteger_TreeMap_Test extends AbstractJDKMapTest<Integer, Integer>{

	@Override
	protected Map<Integer, Integer> getNewMap(int size, int range) {
		return new TreeMap<Integer, Integer>();
	}

	@Override
	protected int generateRandomIndex(int size) {
		return randomGenerator.generateIntegerInRange(size);
	}

	@Override
	protected Integer[] generateRandomKeys(int size, int range) {
		return randomGenerator.generateIntegersInRange(size, range);
	}

	@Override
	protected Integer generateRandomKey(int range) {
		return randomGenerator.generateIntegerInRange(range);
	}

	@Override
	protected Integer[] generateRandomValues(int size) {
		return randomGenerator.generateIntegers(size); // range has no influence here
	}

	@Override
	protected Integer generateRandomValue() {
		return randomGenerator.generateInteger(); // range has no influence here
	}

	@Override
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		return new TreeMap<Integer, Integer>(fullMap2);
	}

}
