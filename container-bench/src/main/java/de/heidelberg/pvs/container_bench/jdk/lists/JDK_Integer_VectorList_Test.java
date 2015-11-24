package de.heidelberg.pvs.container_bench.jdk.lists;

import java.util.List;
import java.util.Vector;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKListTest;

public class JDK_Integer_VectorList_Test extends AbstractJDKListTest<Integer> {

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
		return new Vector<Integer>(size);
	}

	@Override
	protected List<Integer> copyList(List<Integer> fullList2) {
		return new Vector<Integer>(fullList2);
	}

}