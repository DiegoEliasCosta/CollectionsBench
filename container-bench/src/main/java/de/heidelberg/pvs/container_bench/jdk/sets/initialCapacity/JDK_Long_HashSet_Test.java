package de.heidelberg.pvs.container_bench.jdk.sets.initialCapacity;

import java.util.HashSet;
import java.util.Set;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_Long_HashSet_Test extends AbstractJDKSetTest<Long> {

	@Param({ "0", "25", "50", "75", "100", "125", "150"})
	public int initialCapacityRatio;
	
	@Override
	protected Set<Long> getNewSet(int size) {
		int realSize = (int) (size * (double) (initialCapacityRatio/100));
		return new HashSet<>(realSize);
	}

	@Override
	protected Set<Long> copySet(Set<Long> fullSet2) {
		return new HashSet<Long>(fullSet2);
	}

	@Override
	protected RandomGenerator<Long> instantiateRandomGenerator() {
		return new LongRandomGenerator();
	}


}
