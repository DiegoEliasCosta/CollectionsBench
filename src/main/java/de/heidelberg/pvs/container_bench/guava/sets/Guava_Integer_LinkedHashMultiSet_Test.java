package de.heidelberg.pvs.container_bench.guava.sets;

import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiSetTest;

public class Guava_Integer_LinkedHashMultiSet_Test extends AbstractGuavaMultiSetTest<Integer>{

	@Override
	protected Multiset<Integer> getNewMultiSet() {
		return LinkedHashMultiset.create();
	}

	@Override
	protected Multiset<Integer> copyMultiSet(Multiset<Integer> original) {
		return LinkedHashMultiset.create(original);
	}

}
