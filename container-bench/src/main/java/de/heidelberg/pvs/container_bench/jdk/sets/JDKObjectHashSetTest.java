package de.heidelberg.pvs.container_bench.jdk.sets;

import java.util.HashSet;
import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKSetTest;

public class JDKObjectHashSetTest extends AbstractJDKSetTest<Object> {

	@Override
	protected Object[] generateUniqueRandomArray(int size) {
		return randomGenerator.generateElements(size);
	}

	@Override
	protected Integer generateRandomIndex(int size) {
		return randomGenerator.generateIntegerInRange(size);
	}

	@Override
	protected Set<Object> getNewSet(int size) {
		return new HashSet<Object>();
	}

	@Override
	protected Set<Object> copySet(Set<Object> fullSet2) {
		return new HashSet<Object>(fullSet2);
	}

}
