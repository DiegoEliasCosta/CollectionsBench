package de.heidelberg.pvs.container_bench.jdk.sets.initialCapacity;

import java.util.HashSet;
import java.util.Set;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_Integer_HashSet_Test extends AbstractJDKSetTest<Integer> {


	@Param({ "0", "25", "50", "75", "100", "125", "150"})
	public int initialCapacityRatio;
	
	@Override
	protected Set<Integer> getNewSet(int size) {
		int realSize = (int) (size * (double) (initialCapacityRatio/100));
		return new HashSet<>(realSize);
	}

	@Override
	protected Set<Integer> copySet(Set<Integer> fullSet2) {
		return new HashSet<Integer>(fullSet2);
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomGenerator() {
		return new IntegerRandomGenerator();
	}


}