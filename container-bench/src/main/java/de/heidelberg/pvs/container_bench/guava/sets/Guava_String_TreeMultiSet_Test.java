package de.heidelberg.pvs.container_bench.guava.sets;

import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiSetTest;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;

public class Guava_String_TreeMultiSet_Test extends AbstractGuavaMultiSetTest<String> {

	@Override
	protected Multiset<String> getNewMultiSet() {
		return TreeMultiset.create();
	}

	@Override
	protected Multiset<String> copyMultiSet(Multiset<String> original) {
		return TreeMultiset.create(original);
	}

	@Override
	protected RandomGenerator<String> instantiateRandomGenerator() {
		return new StringRandomGenerator();
	}

}
