package de.heidelberg.pvs.container_bench.jdk.sets;

import java.util.HashSet;
import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_Long_HashSet_Test extends AbstractJDKSetTest<Long> {

	@Override
	protected Set<Long> getNewSet(int size) {
		return new HashSet<Long>();
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
