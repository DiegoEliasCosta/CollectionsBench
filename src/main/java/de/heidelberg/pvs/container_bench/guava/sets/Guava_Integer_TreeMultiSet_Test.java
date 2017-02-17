package de.heidelberg.pvs.container_bench.guava.sets;

import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiSetTest;

public class Guava_Integer_TreeMultiSet_Test extends AbstractGuavaMultiSetTest<Integer> {

	@Override
	protected Multiset<Integer> getNewMultiSet() {
		return TreeMultiset.create();
	}

	@Override
	protected Multiset<Integer> copyMultiSet(Multiset<Integer> original) {
		return TreeMultiset.create(original);
	}

}
