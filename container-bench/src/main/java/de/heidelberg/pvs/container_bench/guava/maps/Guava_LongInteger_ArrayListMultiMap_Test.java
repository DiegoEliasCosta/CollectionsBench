package de.heidelberg.pvs.container_bench.guava.maps;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiMapTest;

public class Guava_LongInteger_ArrayListMultiMap_Test extends AbstractGuavaMultiMapTest<Long, Integer>{

	@Override
	protected Multimap<Long, Integer> getNewMultiMap(int size, int rangeOfKeys) {
		return ArrayListMultimap.create();
	}

	@Override
	protected Multimap<Long, Integer> copyMultiMap(Multimap<Long, Integer> original) {
		return ArrayListMultimap.create(original);
	}

}
