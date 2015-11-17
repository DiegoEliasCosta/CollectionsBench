package de.heidelberg.pvs.container_bench.tests.lists;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKArrayListTest;
import de.heidelberg.pvs.container_bench.utils.RandomGenerator;

public class JDKStringArrayListTest extends AbstractJDKArrayListTest<String> {

	@Override
	protected String[] generateRandomArray(int seed, int size) {
		return RandomGenerator.generateStrings(seed, size);
	}

	@Override
	protected Integer generateRandomIndex(int seed, int size) {
		return RandomGenerator.generateInteger(seed, size);
	}

}
