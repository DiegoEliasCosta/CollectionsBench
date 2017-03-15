package de.heidelberg.pvs.container_bench.gscollections.sets;

import java.util.Set;

import com.gs.collections.impl.set.mutable.UnifiedSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

public class GSCollections_Long_UnifiedSet_Test extends AbstractJDKSetTest<Long> {

	@Override
	protected Set<Long> getNewSet() {
		return new UnifiedSet<Long>();
	}

	@Override
	protected Set<Long> copySet(Set<Long> fullSet2) {
		return new UnifiedSet<Long>(fullSet2);
	}
}
