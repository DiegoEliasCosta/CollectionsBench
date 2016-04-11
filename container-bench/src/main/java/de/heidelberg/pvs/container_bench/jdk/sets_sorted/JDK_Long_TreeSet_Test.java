package de.heidelberg.pvs.container_bench.jdk.sets_sorted;

import java.util.Set;
import java.util.TreeSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_Long_TreeSet_Test extends AbstractJDKSetTest<Long> {

	@Override
	protected Set<Long> getNewSet(int size) {
		return new TreeSet<Long>();
	}

	@Override
	protected Set<Long> copySet(Set<Long> fullSet2) {
		return new TreeSet<>(fullSet2);
	}

	@Override
	protected RandomGenerator<Long> instantiateRandomGenerator() {
		return new LongRandomGenerator();
	}

}
