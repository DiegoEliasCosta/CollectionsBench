package de.heidelberg.pvs.container_bench.tests.sets;

import java.util.HashSet;
import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKSetTest;

public class JDKStringHashSetTest extends AbstractJDKSetTest<String> {

	@Override
	protected String[] generateRandomArray(int size) {
		return randomGenerator.generateStrings(size);
	}

	@Override
	protected Set<String> getNewSet(int size) {
		return new HashSet<String>();
	}

	@Override
	protected Set<String> copySet(Set<String> fullSet2) {
		return new HashSet<String>(fullSet2);
	}

}