package de.heidelberg.pvs.container_bench.tests.lists;

import java.util.ArrayList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKListTest;

public class JDKIntegerArrayListTest extends AbstractJDKListTest<Integer> {

	@Override
	protected Integer[] generateRandomArray(int size) {
		return randomGenerator.generateIntegers(size);
	}

	@Override
	protected Integer generateRandomIndex(int size) {
		return randomGenerator.generateIntegerInRange(size);
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
