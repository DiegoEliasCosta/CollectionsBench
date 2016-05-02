package de.heidelberg.pvs.container_bench.guava.maps;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiMapTest;

public class Guava_StringInteger_ArrayListMultiMap_Test extends AbstractGuavaMultiMapTest<String, Integer>{

	@Override
	protected Multimap<String, Integer> getNewMultiMap(int size, int rangeOfKeys) {
		return ArrayListMultimap.create();
	}

	@Override
	protected Multimap<String, Integer> copyMultiMap(Multimap<String, Integer> original) {
		return ArrayListMultimap.create(original);
	}

}
