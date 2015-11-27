package de.heidelberg.pvs.container_bench.jdk.sets;

import java.util.LinkedHashSet;
import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

public class JDK_String_LinkedHashSet_Test extends AbstractJDKSetTest<String> {

	@Override
	protected String[] generateUniqueRandomArray(int size) {
		return randomGenerator.generateStrings(size);
	}

	@Override
	protected Integer generateRandomIndex(int size) {
		return randomGenerator.generateIntegerInRange(size);
	}

	@Override
	protected Set<String> getNewSet(int size) {
		return new LinkedHashSet<>();
	}

	@Override
	protected Set<String> copySet(Set<String> fullSet2) {
		return new LinkedHashSet<>(fullSet2);
	}

}
