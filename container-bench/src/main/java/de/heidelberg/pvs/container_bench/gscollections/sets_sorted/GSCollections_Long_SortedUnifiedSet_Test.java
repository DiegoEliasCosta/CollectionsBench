package de.heidelberg.pvs.container_bench.gscollections.sets_sorted;

import java.util.Set;

import com.gs.collections.impl.set.mutable.SetAdapter;
import com.gs.collections.impl.set.mutable.UnifiedSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

public class GSCollections_Long_SortedUnifiedSet_Test extends AbstractJDKSetTest<Long> {

	@Override
	protected Set<Long> getNewSet(int size) {
		return SetAdapter.adapt(new UnifiedSet<Long>());
	}

	@Override
	protected Set<Long> copySet(Set<Long> fullSet2) {
		return SetAdapter.adapt(new UnifiedSet<Long>(fullSet2));
	}

}
