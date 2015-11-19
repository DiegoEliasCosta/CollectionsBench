package de.heidelberg.pvs.container_bench.tests.lists;

import java.util.ArrayList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKListTest;
import de.heidelberg.pvs.container_bench.utils.RandomGenerator;

public class JDKStringArrayListTest extends AbstractJDKListTest<String> {

	@Override
	protected String[] generateRandomArray(int seed, int size) {
		return RandomGenerator.generateStrings(seed, size);
	}

	@Override
	protected Integer generateRandomIndex(int seed, int size) {
		return RandomGenerator.generateInteger(seed, size);
	}

	@Override
	protected List<String> getNewList(int size) {
		return new ArrayList<String>();
	}

}
