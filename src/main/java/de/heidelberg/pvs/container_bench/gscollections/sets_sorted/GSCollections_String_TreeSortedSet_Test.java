package de.heidelberg.pvs.container_bench.gscollections.sets_sorted;

import java.util.Set;

import com.gs.collections.impl.set.sorted.mutable.TreeSortedSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

public class GSCollections_String_TreeSortedSet_Test extends AbstractJDKSetTest<String> {

	@Override
	protected Set<String> getNewSet() {
		return new TreeSortedSet<>();
	}

	@Override
	protected Set<String> copySet(Set<String> fullSet2) {
		return new TreeSortedSet<>(fullSet2);
	}

}
