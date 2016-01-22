package de.heidelberg.pvs.container_bench.guava.maps;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiMapTest;
import de.heidelberg.pvs.container_bench.element.Element;
import de.heidelberg.pvs.container_bench.random.ElementRandomGenerator;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class Guava_IntegerInteger_ArrayListMultiMap_Test extends AbstractGuavaMultiMapTest<Integer, Integer>{

	@Override
	protected Multimap<Integer, Integer> getNewMultiMap(int size, int rangeOfKeys) {
		return ArrayListMultimap.create();
	}

	@Override
	protected Multimap<Integer, Integer> copyMultiMap(Multimap<Integer, Integer> original) {
		return ArrayListMultimap.create(original);
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomKeyGenerator() {
		return new IntegerRandomGenerator();
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomValueGenerator() {
		return new IntegerRandomGenerator();
	}

}
