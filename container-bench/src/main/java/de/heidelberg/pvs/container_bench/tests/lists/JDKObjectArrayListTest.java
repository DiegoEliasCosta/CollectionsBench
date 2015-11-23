package de.heidelberg.pvs.container_bench.tests.lists;

import java.util.ArrayList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKListTest;

public class JDKObjectArrayListTest extends AbstractJDKListTest<Object>{

	@Override
	protected Object[] generateRandomArray(int size) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
