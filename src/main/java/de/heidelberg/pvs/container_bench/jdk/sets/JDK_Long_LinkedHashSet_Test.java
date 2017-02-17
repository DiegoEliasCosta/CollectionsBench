package de.heidelberg.pvs.container_bench.jdk.sets;

import java.util.LinkedHashSet;
import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

public class JDK_Long_LinkedHashSet_Test extends AbstractJDKSetTest<Long> {

	@Override
	protected Set<Long> getNewSet(int size) {
		return new LinkedHashSet<>();
	}

	@Override
	protected Set<Long> copySet(Set<Long> fullSet2) {
		return new LinkedHashSet<>(fullSet2);
	}

}
