package de.heidelberg.pvs.container_bench.guava.sets;

import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiSetTest;
import de.heidelberg.pvs.container_bench.element.Element;
import de.heidelberg.pvs.container_bench.random.ElementRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class Guava_Element_LinkedHashMultiSet_Test extends AbstractGuavaMultiSetTest<Element>{

	@Override
	protected Multiset<Element> getNewMultiSet() {
		return LinkedHashMultiset.create();
	}

	@Override
	protected Multiset<Element> copyMultiSet(Multiset<Element> original) {
		return LinkedHashMultiset.create(original);
	}

	@Override
	protected RandomGenerator<Element> instantiateRandomGenerator() {
		return new ElementRandomGenerator();
	}

}
