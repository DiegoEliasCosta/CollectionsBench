package de.heidelberg.pvs.container_bench.guava.sets;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiSetTest;

public class Guava_Integer_HashMultiSet_Test extends AbstractGuavaMultiSetTest<Integer> {


	@Override
	protected Multiset<Integer> getNewMultiSet() {
		return HashMultiset.create();
	}

	@Override
	protected Multiset<Integer> copyMultiSet(Multiset<Integer> original) {
		return HashMultiset.create(original);
	}

	
}
