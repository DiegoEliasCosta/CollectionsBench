package de.heidelberg.pvs.container_bench.jdk.sets;

import java.util.LinkedHashSet;
import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;

public class JDK_String_LinkedHashSet_Test extends AbstractJDKSetTest<String> {

	@Override
	protected Set<String> getNewSet(int size) {
		return new LinkedHashSet<>();
	}

	@Override
	protected Set<String> copySet(Set<String> fullSet2) {
		return new LinkedHashSet<>(fullSet2);
	}

	@Override
	protected RandomGenerator<String> instantiateRandomGenerator() {
		return new StringRandomGenerator();
	}

}
