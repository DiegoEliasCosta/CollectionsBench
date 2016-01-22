package de.heidelberg.pvs.container_bench.guava.maps;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiMapTest;
import de.heidelberg.pvs.container_bench.element.Element;
import de.heidelberg.pvs.container_bench.random.ElementRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;

public class Guava_StringElement_ArrayListMultiMap_Test extends AbstractGuavaMultiMapTest<String, Element>{

	@Override
	protected Multimap<String, Element> getNewMultiMap(int size, int rangeOfKeys) {
		return ArrayListMultimap.create();
	}

	@Override
	protected Multimap<String, Element> copyMultiMap(Multimap<String, Element> original) {
		return ArrayListMultimap.create(original);
	}

	@Override
	protected RandomGenerator<String> instantiateRandomKeyGenerator() {
		return new StringRandomGenerator();
	}

	@Override
	protected RandomGenerator<Element> instantiateRandomValueGenerator() {
		return new ElementRandomGenerator();
	}

}
