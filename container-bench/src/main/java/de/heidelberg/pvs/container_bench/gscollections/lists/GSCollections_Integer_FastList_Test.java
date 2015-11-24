package de.heidelberg.pvs.container_bench.gscollections.lists;

import java.util.List;

import com.gs.collections.impl.list.mutable.FastList;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;

public class GSCollections_Integer_FastList_Test extends AbstractJDKListTest<Integer>{

	@Override
	protected Integer[] generateRandomArray(int size) {
		return randomGenerator.generateIntegers(size);
	}

	@Override
	protected Integer generateRandomIndex(int range) {
		return randomGenerator.generateIntegerInRange(range);
	}

	@Override
	protected List<Integer> getNewList(int size) {
		return new FastList<Integer>();
	}

	@Override
	protected List<Integer> copyList(List<Integer> fullList2) {
		return new FastList<Integer>(fullList2);
	}

}
