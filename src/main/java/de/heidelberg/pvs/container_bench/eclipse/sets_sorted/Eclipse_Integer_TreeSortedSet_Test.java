package de.heidelberg.pvs.container_bench.eclipse.sets_sorted;

import java.util.Set;

import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

public class Eclipse_Integer_TreeSortedSet_Test extends AbstractJDKSetTest<Integer> {

	@Override
	protected Set<Integer> getNewSet() {
		return new TreeSortedSet<Integer>();
	}

	@Override
	protected Set<Integer> copySet(Set<Integer> fullSet2) {
		return new TreeSortedSet<Integer>(fullSet2);

	}
}
