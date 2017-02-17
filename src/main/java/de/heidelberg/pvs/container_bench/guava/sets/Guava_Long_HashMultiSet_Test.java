package de.heidelberg.pvs.container_bench.guava.sets;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiSetTest;

public class Guava_Long_HashMultiSet_Test extends AbstractGuavaMultiSetTest<Long> {

	@Override
	protected Multiset<Long> getNewMultiSet() {
		return HashMultiset.create();
	}

	@Override
	protected Multiset<Long> copyMultiSet(Multiset<Long> original) {
		return HashMultiset.create(original);
	}

	
}
