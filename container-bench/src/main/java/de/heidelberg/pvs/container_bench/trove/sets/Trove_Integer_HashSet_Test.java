package de.heidelberg.pvs.container_bench.trove.sets;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import gnu.trove.set.hash.THashSet;

public class Trove_Integer_HashSet_Test extends AbstractJDKSetTest<Integer> {

	@Override
	protected Set<Integer> getNewSet(int size) {
		return new THashSet<>();
	}

	@Override
	protected Set<Integer> copySet(Set<Integer> fullSet2) {
		return new THashSet<>(fullSet2);
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomGenerator() {
		return new IntegerRandomGenerator();
	}

}
