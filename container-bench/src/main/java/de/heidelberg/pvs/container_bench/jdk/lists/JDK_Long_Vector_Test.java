package de.heidelberg.pvs.container_bench.jdk.lists;

import java.util.List;
import java.util.Vector;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_Long_Vector_Test extends AbstractJDKListTest<Long> {

	@Override
	protected List<Long> getNewList(int size) {
		return new Vector<Long>();
	}

	@Override
	protected List<Long> copyList(List<Long> fullList2) {
		return new Vector<Long>(fullList2);
	}

	@Override
	protected RandomGenerator<Long> instantiateRandomGenerator() {
		return new LongRandomGenerator();
	}

}
