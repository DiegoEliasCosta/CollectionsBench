package de.heidelberg.pvs.container_bench.jdk.sets.initialCapacity;

import java.util.HashSet;
import java.util.Set;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;

public class JDK_String_HashSet_Test extends AbstractJDKSetTest<String> {

	@Param({ "0", "25", "50", "75", "100", "125", "150"})
	public int initialCapacityRatio;
	
	@Override
	protected Set<String> getNewSet(int size) {
		int realSize = (int) (size * (double) (initialCapacityRatio/100));
		return new HashSet<>(realSize);
	}

	@Override
	protected Set<String> copySet(Set<String> fullSet2) {
		return new HashSet<String>(fullSet2);
	}

	@Override
	protected RandomGenerator<String> instantiateRandomGenerator() {
		return new StringRandomGenerator();
	}

}