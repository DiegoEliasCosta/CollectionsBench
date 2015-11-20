package de.heidelberg.pvs.container_bench.tests.maps;

import java.util.HashMap;
import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKMapTest;
import de.heidelberg.pvs.container_bench.utils.RandomGenerator;

public class JDKIntegerIntegerHashMapTest extends AbstractJDKMapTest<Integer, Integer> {

	@Override
	protected Map<Integer, Integer> getNewMap(int size, int seed, int range) {
		return new HashMap<Integer, Integer>();
	}

	@Override
	protected int generateRandomIndex(int size, int seed) {
		return RandomGenerator.generateInteger(seed, size);
	}

	@Override
	protected Integer[] generateRandomKeys(int size, int seed, int range) {
		return RandomGenerator.generateIntegers(seed, size, range);
	}

	@Override
	protected Integer generateRandomKey(int seed, int range) {
		return RandomGenerator.generateInteger(seed, range);
	}

	@Override
	protected Integer[] generateRandomValues(int size, int seed, int range) {
		return RandomGenerator.generateIntegers(seed, size, range);
	}

	@Override
	protected Integer generateRandomValue(int seed, int range) {
		return RandomGenerator.generateInteger(seed, range);
	}

}
