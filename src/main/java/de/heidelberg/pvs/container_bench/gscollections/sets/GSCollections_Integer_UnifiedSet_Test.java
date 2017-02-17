package de.heidelberg.pvs.container_bench.gscollections.sets;

import java.util.Set;

import com.gs.collections.impl.set.mutable.UnifiedSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

public class GSCollections_Integer_UnifiedSet_Test extends AbstractJDKSetTest<Integer> {

	@Override
	protected Set<Integer> getNewSet(int size) {
		return new UnifiedSet<Integer>();
	}

	@Override
	protected Set<Integer> copySet(Set<Integer> fullSet2) {
		return new UnifiedSet<Integer>(fullSet2);
	}


}
