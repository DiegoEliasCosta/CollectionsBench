package de.heidelberg.pvs.container_bench.jdk.lists;

import java.util.LinkedList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_Long_LinkedList_Test extends AbstractJDKListTest<Long>{

	@Override
	protected List<Long> getNewList(int size) {
		return new LinkedList<Long>();
	}

	@Override
	protected List<Long> copyList(List<Long> fullList2) {
		return new LinkedList<Long>(fullList2);
	}

	@Override
	protected RandomGenerator<Long> instantiateRandomGenerator() {
		return new LongRandomGenerator();
	}

}
