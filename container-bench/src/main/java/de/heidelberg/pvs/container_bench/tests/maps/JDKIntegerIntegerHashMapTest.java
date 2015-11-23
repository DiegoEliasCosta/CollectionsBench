package de.heidelberg.pvs.container_bench.tests.maps;

import java.util.HashMap;
import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKMapTest;

public class JDKIntegerIntegerHashMapTest extends AbstractJDKMapTest<Integer, Integer> {

	@Override
	protected Map<Integer, Integer> getNewMap(int size, int range) {
		return new HashMap<Integer, Integer>();
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
	protected Integer[] generateRandomValues(int size, int range) {
		return randomGenerator.generateIntegers(size); // The range here is irrelevant
	}

	@Override
	protected Integer generateRandomValue(int range) {
		return randomGenerator.generateIntegerInRange(range);
	}

	@Override
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		return new HashMap<Integer, Integer>(fullMap2);
	}

}
