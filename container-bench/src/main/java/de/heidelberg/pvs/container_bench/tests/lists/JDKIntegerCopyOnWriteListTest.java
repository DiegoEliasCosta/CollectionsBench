package de.heidelberg.pvs.container_bench.tests.lists;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKListTest;

public class JDKIntegerCopyOnWriteListTest extends AbstractJDKListTest<Integer> {

	@Override
	protected Integer[] generateRandomArray(int seed, int size) {
		return randomGenerator.generateIntegers(seed, size);
	}

	@Override
	protected Integer generateRandomIndex(int seed, int size) {
		return randomGenerator.generateIntegerInRange(seed, size);
	}

	@Override
	protected List<Integer> getNewList(int size) {
		return new CopyOnWriteArrayList<Integer>(); // There is no option for creating a list of specifying size
	}

}
