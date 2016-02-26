package de.heidelberg.pvs.container_bench.jdk.lists.initialCapacity;

import java.util.ArrayList;
import java.util.List;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;

public class JDK_String_ArrayList_Test extends AbstractJDKListTest<String> {

	@Param({ "0", "25", "50", "75", "100", "125", "150"})
	public int initialCapacityRatio;

	@Override
	protected List<String> getNewList(int size) {
		int realSize = (int) (size * (double) (initialCapacityRatio/100));
		return new ArrayList<String>(realSize);
	}

	@Override
	protected List<String> copyList(List<String> fullList2) {
		return new ArrayList<String>(fullList2);
	}

	@Override
	protected RandomGenerator<String> instantiateRandomGenerator() {
		return new StringRandomGenerator();
	}

}
