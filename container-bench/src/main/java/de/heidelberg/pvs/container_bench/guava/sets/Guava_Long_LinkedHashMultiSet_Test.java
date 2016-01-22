package de.heidelberg.pvs.container_bench.guava.sets;

import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiSetTest;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class Guava_Long_LinkedHashMultiSet_Test extends AbstractGuavaMultiSetTest<Long>{

	@Override
	protected Multiset<Long> getNewMultiSet() {
		return LinkedHashMultiset.create();
	}

	@Override
	protected Multiset<Long> copyMultiSet(Multiset<Long> original) {
		return LinkedHashMultiset.create(original);
	}

	@Override
	protected RandomGenerator<Long> instantiateRandomGenerator() {
		return new LongRandomGenerator();
	}

}
