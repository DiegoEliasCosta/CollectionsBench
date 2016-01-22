package de.heidelberg.pvs.container_bench.guava.sets;

import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiSetTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class Guava_Integer_LinkedHashMultiSet_Test extends AbstractGuavaMultiSetTest<Integer>{

	@Override
	protected Multiset<Integer> getNewMultiSet() {
		return LinkedHashMultiset.create();
	}

	@Override
	protected Multiset<Integer> copyMultiSet(Multiset<Integer> original) {
		return LinkedHashMultiset.create(original);
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomGenerator() {
		return new IntegerRandomGenerator();
	}

}
