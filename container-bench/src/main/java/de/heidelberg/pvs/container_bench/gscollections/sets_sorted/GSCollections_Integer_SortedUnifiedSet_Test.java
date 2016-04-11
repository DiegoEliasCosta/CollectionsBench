package de.heidelberg.pvs.container_bench.gscollections.sets_sorted;

import java.util.Set;

import com.gs.collections.impl.set.mutable.SetAdapter;
import com.gs.collections.impl.set.mutable.UnifiedSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class GSCollections_Integer_SortedUnifiedSet_Test extends AbstractJDKSetTest<Integer> {

	@Override
	protected Set<Integer> getNewSet(int size) {
		return SetAdapter.adapt(new UnifiedSet<Integer>());
	}

	@Override
	protected Set<Integer> copySet(Set<Integer> fullSet2) {
		return SetAdapter.adapt(new UnifiedSet<Integer>(fullSet2));
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomGenerator() {
		return new IntegerRandomGenerator();
	}

}
