package de.heidelberg.pvs.container_bench.guava.sets;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiSetTest;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class Guava_Long_HashMultiSet_Test extends AbstractGuavaMultiSetTest<Long> {


	@Override
	protected RandomGenerator<Long> instantiateRandomGenerator() {
		return new LongRandomGenerator();
	}

	@Override
	protected Multiset<Long> getNewMultiSet() {
		return HashMultiset.create();
	}

	@Override
	protected Multiset<Long> copyMultiSet(Multiset<Long> original) {
		return HashMultiset.create(original);
	}

	
}
