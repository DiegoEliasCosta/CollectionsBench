package de.heidelberg.pvs.container_bench.jdk.sets_sorted;

import java.util.Set;
import java.util.TreeSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_Integer_TreeSet_Test extends AbstractJDKSetTest<Integer> {


	@Override
	protected Set<Integer> getNewSet(int size) {
		return new TreeSet<Integer>(); // cannot specify size
	}

	@Override
	protected Set<Integer> copySet(Set<Integer> fullSet2) {
		return new TreeSet<Integer>(fullSet2);
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomGenerator() {
		return new IntegerRandomGenerator();
	}

}
