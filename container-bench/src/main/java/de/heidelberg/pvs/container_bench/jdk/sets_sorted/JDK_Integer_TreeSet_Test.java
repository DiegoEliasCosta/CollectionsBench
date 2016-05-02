package de.heidelberg.pvs.container_bench.jdk.sets_sorted;

import java.util.Set;
import java.util.TreeSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

public class JDK_Integer_TreeSet_Test extends AbstractJDKSetTest<Integer> {


	@Override
	protected Set<Integer> getNewSet(int size) {
		return new TreeSet<Integer>(); // cannot specify size
	}

	@Override
	protected Set<Integer> copySet(Set<Integer> fullSet2) {
		return new TreeSet<Integer>(fullSet2);
	}

}
