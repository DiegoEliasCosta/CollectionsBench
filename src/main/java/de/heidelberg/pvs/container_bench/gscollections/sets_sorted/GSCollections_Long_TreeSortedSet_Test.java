package de.heidelberg.pvs.container_bench.gscollections.sets_sorted;

import java.util.Set;

import com.gs.collections.impl.set.sorted.mutable.TreeSortedSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

public class GSCollections_Long_TreeSortedSet_Test extends AbstractJDKSetTest<Long> {

	@Override
	protected Set<Long> getNewSet() {
		return new TreeSortedSet<>();
	}

	@Override
	protected Set<Long> copySet(Set<Long> fullSet2) {
		return new TreeSortedSet<>(fullSet2);
	}

}
