package de.heidelberg.pvs.container_bench.guava.maps;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiMapTest;

public class Guava_IntegerInteger_HashMultimap_Test extends AbstractGuavaMultiMapTest<Integer, Integer> {

	@Override
	protected Multimap<Integer, Integer> getNewMultiMap(int size, int rangeOfKeys) {
		return HashMultimap.create();
	}

	@Override
	protected Multimap<Integer, Integer> copyMultiMap(Multimap<Integer, Integer> original) {
		return HashMultimap.create(original);
	}

}
