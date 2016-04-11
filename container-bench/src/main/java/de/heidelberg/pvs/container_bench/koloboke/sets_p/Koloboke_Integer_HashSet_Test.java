package de.heidelberg.pvs.container_bench.koloboke.sets_p;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import net.openhft.koloboke.collect.set.hash.HashIntSets;

public class Koloboke_Integer_HashSet_Test extends AbstractJDKSetTest<Integer> {

	@Override
	protected Set<Integer> getNewSet(int size) {
		return HashIntSets.newMutableSet();
	}

	@Override
	protected Set<Integer> copySet(Set<Integer> fullSet2) {
		return HashIntSets.newMutableSet(fullSet2);
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomGenerator() {
		return new IntegerRandomGenerator();
	}
	

}
