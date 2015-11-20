package de.heidelberg.pvs.container_bench.tests.lists;

import java.util.LinkedList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKListTest;

public class JDKStringLinkedListTest extends AbstractJDKListTest<String> {

	@Override
	protected String[] generateRandomArray(int seed, int size) {
		return randomGenerator.generateStrings(seed, size);
	}

	@Override
	protected Integer generateRandomIndex(int seed, int size) {
		return randomGenerator.generateIntegerInRange(seed, size);
	}

	@Override
	protected List<String> getNewList(int size) {
		return new LinkedList<String>(); 
	}

}
