package de.heidelberg.pvs.container_bench.guava.maps;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiMapTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class Guava_IntegerInteger_LinkedHashMultiMap_Test extends AbstractGuavaMultiMapTest<Integer, Integer> {

	@Override
	protected Multimap<Integer, Integer> getNewMultiMap(int size, int rangeOfKeys) {
		return LinkedHashMultimap.create();
	}

	@Override
	protected Multimap<Integer, Integer> copyMultiMap(Multimap<Integer, Integer> original) {
		return LinkedHashMultimap.create(original);
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
