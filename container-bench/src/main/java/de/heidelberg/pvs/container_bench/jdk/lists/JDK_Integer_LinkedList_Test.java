package de.heidelberg.pvs.container_bench.jdk.lists;

import java.util.LinkedList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_Integer_LinkedList_Test extends AbstractJDKListTest<Integer> {

	@Override
	protected List<Integer> getNewList(int size) {
		return new LinkedList<Integer>();
	}

	@Override
	protected List<Integer> copyList(List<Integer> fullList2) {
		return new LinkedList<Integer>(fullList2);
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomGenerator() {
		return new IntegerRandomGenerator();
	}
	
	

}
