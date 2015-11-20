package de.heidelberg.pvs.container_bench.tests.maps;

import java.util.HashMap;
import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKMapTest;

public class JDKIntegerIntegerHashMapTest extends AbstractJDKMapTest<Integer, Integer> {

	@Override
	protected Map<Integer, Integer> getNewMap(int size, int seed, int range) {
		return new HashMap<Integer, Integer>();
	}

	@Override
	protected int generateRandomIndex(int size, int seed) {
		return randomGenerator.generateIntegerInRange(seed, size);
	}

	@Override
	protected Integer[] generateRandomKeys(int size, int seed, int range) {
		return randomGenerator.generateIntegersInRange(seed, size, range);
	}

	@Override
	protected Integer generateRandomKey(int seed, int range) {
		return randomGenerator.generateIntegerInRange(seed, range);
	}

	@Override
	protected Integer[] generateRandomValues(int size, int seed, int range) {
		return randomGenerator.generateIntegers(seed, size); // The range here is irrelevant
	}

	@Override
	protected Integer generateRandomValue(int seed, int range) {
		return randomGenerator.generateIntegerInRange(seed, range);
	}

}
