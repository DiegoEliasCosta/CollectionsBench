package de.heidelberg.pvs.container_bench.tests.lists;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKArrayListTest;
import de.heidelberg.pvs.container_bench.utils.RandomGenerator;

public class JDKIntegerArrayListTest extends AbstractJDKArrayListTest<Integer> {

	@Override
	protected Integer[] generateRandomArray(int seed, int size) {
		return RandomGenerator.generateIntegers(seed, size);
	}

	@Override
	protected Integer generateRandomIndex(int seed, int size) {
		return RandomGenerator.generateInteger(seed, size);
	}

}
