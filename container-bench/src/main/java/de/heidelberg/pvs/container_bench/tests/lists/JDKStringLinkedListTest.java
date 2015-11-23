package de.heidelberg.pvs.container_bench.tests.lists;

import java.util.LinkedList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKListTest;

public class JDKStringLinkedListTest extends AbstractJDKListTest<String> {

	@Override
	protected String[] generateRandomArray(int size) {
		return randomGenerator.generateStrings(size);
	}

	@Override
	protected Integer generateRandomIndex(int size) {
		return randomGenerator.generateIntegerInRange(size);
	}

	@Override
	protected List<String> getNewList(int size) {
		return new LinkedList<String>(); 
	}

	@Override
	protected List<String> copyList(List<String> fullList2) {
		return new LinkedList<String>(fullList2);
	}

}
