package de.heidelberg.pvs.container_bench.jdk.lists;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKListTest;

public class JDKIntegerCopyOnWriteListTest extends AbstractJDKListTest<Integer> {
	
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
		return new CopyOnWriteArrayList<Integer>(); // There is no option for creating a list of specifying size
	}

	@Override
	protected List<Integer> copyList(List<Integer> fullList2) {
		return new CopyOnWriteArrayList<Integer>(fullList2);
	}

}
