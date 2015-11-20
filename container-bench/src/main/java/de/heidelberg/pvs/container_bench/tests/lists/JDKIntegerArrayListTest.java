package de.heidelberg.pvs.container_bench.tests.lists;

import java.util.ArrayList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKListTest;

public class JDKIntegerArrayListTest extends AbstractJDKListTest<Integer> {

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
		return new ArrayList<Integer>();
	}

	@Override
	protected List<Integer> copyList(List<Integer> fullList2) {
		return new ArrayList<Integer>(fullList2);
	}

}
