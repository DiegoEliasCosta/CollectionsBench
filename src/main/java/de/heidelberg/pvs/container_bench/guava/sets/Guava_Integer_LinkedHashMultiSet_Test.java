package de.heidelberg.pvs.container_bench.guava.sets;

import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiSetBench;

public class Guava_Integer_LinkedHashMultiSet_Test extends AbstractGuavaMultiSetBench<Integer>{

	@Override
	protected Multiset<Integer> getNewMultiSet() {
		return LinkedHashMultiset.create();
	}

	@Override
	protected Multiset<Integer> copyMultiSet(Multiset<Integer> original) {
		return LinkedHashMultiset.create(original);
	}

}
