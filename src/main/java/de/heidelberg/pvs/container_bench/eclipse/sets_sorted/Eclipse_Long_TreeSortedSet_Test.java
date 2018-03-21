package de.heidelberg.pvs.container_bench.eclipse.sets_sorted;

import java.util.Set;

import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

public class Eclipse_Long_TreeSortedSet_Test extends AbstractJDKSetTest<Long> {

	@Override
	protected Set<Long> getNewSet() {
		return new TreeSortedSet<>();
	}

	@Override
	protected Set<Long> copySet(Set<Long> fullSet2) {
		return new TreeSortedSet<>(fullSet2);
	}

}
