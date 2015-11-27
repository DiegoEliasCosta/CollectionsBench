package de.heidelberg.pvs.container_bench.guava.sets;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class Guava_Integer_HashMultiSet_Test extends AbstractJDKSetTest<Integer> {


	@Override
	protected Set<Integer> getNewSet(int size) {
		// TODO
		return null;
	}

	@Override
	protected Set<Integer> copySet(Set<Integer> fullSet2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomGenerator() {
		return new IntegerRandomGenerator();
	}

	
}
