package de.heidelberg.pvs.container_bench.fastutils.sets_sorted;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import it.unimi.dsi.fastutil.objects.ObjectRBTreeSet;

public class FastUtils_Integer_RBTreeSet_Test extends AbstractJDKSetTest<Integer> {

	@Override
	protected Set<Integer> getNewSet(int size) {
		return new ObjectRBTreeSet<>();
	}

	@Override
	protected Set<Integer> copySet(Set<Integer> fullSet2) {
		return new ObjectRBTreeSet<>(fullSet2);
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomGenerator() {
		return new IntegerRandomGenerator();
	}

}
