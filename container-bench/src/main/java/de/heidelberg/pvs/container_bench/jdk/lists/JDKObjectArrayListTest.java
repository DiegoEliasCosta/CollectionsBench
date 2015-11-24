package de.heidelberg.pvs.container_bench.jdk.lists;

import java.util.ArrayList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKListTest;

public class JDKObjectArrayListTest extends AbstractJDKListTest<Object>{

	@Override
	protected Object[] generateRandomArray(int size) {
		return randomGenerator.generateElements(size);
	}

	@Override
	protected Integer generateRandomIndex(int size) {
		return randomGenerator.generateIntegerInRange(size);
	}

	@Override
	protected List<Object> getNewList(int size) {
		return new ArrayList<Object>(size);
	}

	@Override
	protected List<Object> copyList(List<Object> fullList2) {
		return new ArrayList<Object>(fullList2);
	}

}
