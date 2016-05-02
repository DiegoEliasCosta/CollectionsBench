package de.heidelberg.pvs.container_bench.jdk.sets;

import java.util.HashSet;
import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

public class JDK_String_HashSet_Test extends AbstractJDKSetTest<String> {

	@Override
	protected Set<String> getNewSet(int size) {
		return new HashSet<String>();
	}

	@Override
	protected Set<String> copySet(Set<String> fullSet2) {
		return new HashSet<String>(fullSet2);
	}

}