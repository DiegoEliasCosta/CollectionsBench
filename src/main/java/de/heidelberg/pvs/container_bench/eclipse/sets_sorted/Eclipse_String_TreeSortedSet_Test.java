package de.heidelberg.pvs.container_bench.eclipse.sets_sorted;

import java.util.Set;

import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

public class Eclipse_String_TreeSortedSet_Test extends AbstractJDKSetTest<String> {

	@Override
	protected Set<String> getNewSet() {
		return new TreeSortedSet<>();
	}

	@Override
	protected Set<String> copySet(Set<String> fullSet2) {
		return new TreeSortedSet<>(fullSet2);
	}

}
