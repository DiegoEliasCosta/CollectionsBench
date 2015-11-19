package de.heidelberg.pvs.container_bench.tests.lists;

import java.util.List;
import java.util.Vector;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKListTest;
import de.heidelberg.pvs.container_bench.utils.RandomGenerator;

public class JDKIntegerVectorListTest extends AbstractJDKListTest<Integer> {

	@Override
	protected Integer[] generateRandomArray(int seed, int size) {
		return RandomGenerator.generateIntegers(seed, size);
	}

	@Override
	protected Integer generateRandomIndex(int seed, int size) {
		return RandomGenerator.generateInteger(seed, size);
	}

	@Override
	protected List<Integer> getNewList(int size) {
		return new Vector<Integer>(size);
	}

}
