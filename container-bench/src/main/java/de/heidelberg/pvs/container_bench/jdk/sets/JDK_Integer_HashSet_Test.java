package de.heidelberg.pvs.container_bench.jdk.sets;

import java.util.HashSet;
import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_Integer_HashSet_Test extends AbstractJDKSetTest<Integer> {


	@Override
	protected Set<Integer> getNewSet(int size) {
		return new HashSet<Integer>();
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