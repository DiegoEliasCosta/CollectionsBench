package de.heidelberg.pvs.container_bench.jdk.lists.initialCapacity;

import java.util.ArrayList;
import java.util.List;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_Integer_ArrayList_Test extends AbstractJDKListTest<Integer> {
	
	@Param({ "0", "25", "50", "75", "100", "125", "150"})
	public int initialCapacityRatio;
	
	@Override
	protected List<Integer> getNewList(int size) {
		int realSize = (int) (size * (double) (initialCapacityRatio/100));
		return new ArrayList<Integer>(realSize);
	}

	@Override
	protected List<Integer> copyList(List<Integer> fullList2) {
		return new ArrayList<Integer>(fullList2);
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomGenerator() {
		return new IntegerRandomGenerator();
	}

}
