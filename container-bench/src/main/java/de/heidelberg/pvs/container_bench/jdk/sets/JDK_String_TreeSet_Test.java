package de.heidelberg.pvs.container_bench.jdk.sets;

import java.util.Set;
import java.util.TreeSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

public class JDK_String_TreeSet_Test extends AbstractJDKSetTest<String> {

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
		return new TreeSet<>();
	}

	@Override
	protected Set<String> copySet(Set<String> fullSet2) {
		return new TreeSet<>(fullSet2);
	}

}
