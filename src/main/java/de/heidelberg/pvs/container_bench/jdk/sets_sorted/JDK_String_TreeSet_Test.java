package de.heidelberg.pvs.container_bench.jdk.sets_sorted;

import java.util.Set;
import java.util.TreeSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

public class JDK_String_TreeSet_Test extends AbstractJDKSetTest<String> {

	@Override
	protected Set<String> getNewSet(int size) {
		return new TreeSet<>();
	}

	@Override
	protected Set<String> copySet(Set<String> fullSet2) {
		return new TreeSet<>(fullSet2);
	}

}
