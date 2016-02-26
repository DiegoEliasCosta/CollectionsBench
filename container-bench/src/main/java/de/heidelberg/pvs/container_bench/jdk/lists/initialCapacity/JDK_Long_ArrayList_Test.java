package de.heidelberg.pvs.container_bench.jdk.lists.initialCapacity;

import java.util.ArrayList;
import java.util.List;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_Long_ArrayList_Test extends AbstractJDKListTest<Long> {
	
	@Param({ "0", "25", "50", "75", "100", "125", "150"})
	public int initialCapacityRatio;

	@Override
	protected List<Long> getNewList(int size) {
		int realSize = (int) (size * (double) (initialCapacityRatio/100));
		return new ArrayList<Long>(realSize);
	}

	@Override
	protected List<Long> copyList(List<Long> fullList2) {
		return new ArrayList<Long>(fullList2);
	}

	@Override
	protected RandomGenerator<Long> instantiateRandomGenerator() {
		return new LongRandomGenerator();
	}

}
