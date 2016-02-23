package de.heidelberg.pvs.container_bench.koloboke.sets;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import net.openhft.koloboke.collect.set.hash.HashLongSets;
import net.openhft.koloboke.collect.set.hash.HashObjSets;

public class Koloboke_Long_HashSet_Test extends AbstractJDKSetTest<Long> {

	@Override
	protected Set<Long> getNewSet(int size) {
		return HashObjSets.newMutableSet();
	}

	@Override
	protected Set<Long> copySet(Set<Long> fullSet2) {
		return HashObjSets.newMutableSet(fullSet2);
	}

	@Override
	protected RandomGenerator<Long> instantiateRandomGenerator() {
		return new LongRandomGenerator();
	}
	

}
