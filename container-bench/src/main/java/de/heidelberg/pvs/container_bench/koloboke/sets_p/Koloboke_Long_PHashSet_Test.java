package de.heidelberg.pvs.container_bench.koloboke.sets_p;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import net.openhft.koloboke.collect.set.hash.HashLongSets;

public class Koloboke_Long_PHashSet_Test extends AbstractJDKSetTest<Long> {

	@Override
	protected Set<Long> getNewSet(int size) {
		return HashLongSets.newMutableSet();
	}

	@Override
	protected Set<Long> copySet(Set<Long> fullSet2) {
		return HashLongSets.newMutableSet(fullSet2);
	}

	@Override
	protected RandomGenerator<Long> instantiateRandomGenerator() {
		return new LongRandomGenerator();
	}
	

}
