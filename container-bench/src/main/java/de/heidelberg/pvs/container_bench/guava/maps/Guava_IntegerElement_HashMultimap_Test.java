package de.heidelberg.pvs.container_bench.guava.maps;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiMapTest;
import de.heidelberg.pvs.container_bench.element.Element;
import de.heidelberg.pvs.container_bench.random.ElementRandomGenerator;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class Guava_IntegerElement_HashMultimap_Test extends AbstractGuavaMultiMapTest<Integer, Element> {

	@Override
	protected Multimap<Integer, Element> getNewMultiMap(int size, int rangeOfKeys) {
		return HashMultimap.create();
	}

	@Override
	protected Multimap<Integer, Element> copyMultiMap(Multimap<Integer, Element> original) {
		return HashMultimap.create(original);
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomKeyGenerator() {
		return new IntegerRandomGenerator();
	}

	@Override
	protected RandomGenerator<Element> instantiateRandomValueGenerator() {
		return new ElementRandomGenerator();
	}

}
