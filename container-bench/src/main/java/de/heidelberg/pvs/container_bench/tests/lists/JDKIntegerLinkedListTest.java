package de.heidelberg.pvs.container_bench.tests.lists;

import java.util.LinkedList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKListTest;
import de.heidelberg.pvs.container_bench.utils.RandomGenerator;

public class JDKIntegerLinkedListTest extends AbstractJDKListTest<Integer> {

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
		return new LinkedList<Integer>();
	}
	
	

}
