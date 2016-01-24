package de.heidelberg.pvs.container_bench.trove.sets;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import gnu.trove.set.hash.THashSet;

public class Trove_Long_HashSet_Test extends AbstractJDKSetTest<Long> {

	@Override
	protected Set<Long> getNewSet(int size) {
		return new THashSet<>();
	}

	@Override
	protected Set<Long> copySet(Set<Long> fullSet2) {
		return new THashSet<>(fullSet2);
	}

	@Override
	protected RandomGenerator<Long> instantiateRandomGenerator() {
		return new LongRandomGenerator();
	}

}
