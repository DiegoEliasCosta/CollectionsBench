package de.heidelberg.pvs.container_bench.guava.sets;

import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiSetTest;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class Guava_Long_TreeMultiSet_Test extends AbstractGuavaMultiSetTest<Long> {

	@Override
	protected Multiset<Long> getNewMultiSet() {
		return TreeMultiset.create();
	}

	@Override
	protected Multiset<Long> copyMultiSet(Multiset<Long> original) {
		return TreeMultiset.create(original);
	}

	@Override
	protected RandomGenerator<Long> instantiateRandomGenerator() {
		return new LongRandomGenerator();
	}

}
