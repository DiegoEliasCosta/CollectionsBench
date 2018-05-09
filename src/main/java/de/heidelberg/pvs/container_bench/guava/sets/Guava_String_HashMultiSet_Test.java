package de.heidelberg.pvs.container_bench.guava.sets;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiSetBench;

public class Guava_String_HashMultiSet_Test extends AbstractGuavaMultiSetBench<String> {

	@Override
	protected Multiset<String> getNewMultiSet() {
		return HashMultiset.create();
	}

	@Override
	protected Multiset<String> copyMultiSet(Multiset<String> original) {
		return HashMultiset.create(original);
	}

	
}
