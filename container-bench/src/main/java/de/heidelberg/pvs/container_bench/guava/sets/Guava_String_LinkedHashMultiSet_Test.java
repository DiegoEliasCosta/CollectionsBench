package de.heidelberg.pvs.container_bench.guava.sets;

import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiSetTest;

public class Guava_String_LinkedHashMultiSet_Test extends AbstractGuavaMultiSetTest<String>{

	@Override
	protected Multiset<String> getNewMultiSet() {
		return LinkedHashMultiset.create();
	}

	@Override
	protected Multiset<String> copyMultiSet(Multiset<String> original) {
		return LinkedHashMultiset.create(original);
	}

}
