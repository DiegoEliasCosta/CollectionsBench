package de.heidelberg.pvs.container_bench.jdk.sets;

import java.util.HashSet;
import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKSetTest;

public class JDKIntegerHashSetTest extends AbstractJDKSetTest<Integer> {

	@Override
	protected Integer[] generateUniqueRandomArray(int size) {
		return randomGenerator.generateIntegers(size);
	}

	@Override
	protected Set<Integer> getNewSet(int size) {
		return new HashSet<Integer>();
	}

	@Override
	protected Set<Integer> copySet(Set<Integer> fullSet2) {
		return new HashSet<Integer>(fullSet2);
	}

	@Override
	protected Integer generateRandomIndex(int size) {
		return randomGenerator.generateIntegerInRange(size);
	}

}