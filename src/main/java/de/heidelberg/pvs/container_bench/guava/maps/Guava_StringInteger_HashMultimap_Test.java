package de.heidelberg.pvs.container_bench.guava.maps;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiMapBench;

public class Guava_StringInteger_HashMultimap_Test extends AbstractGuavaMultiMapBench<String, Integer> {

	@Override
	protected Multimap<String, Integer> getNewMultiMap(int size, int rangeOfKeys) {
		return HashMultimap.create();
	}

	@Override
	protected Multimap<String, Integer> copyMultiMap(Multimap<String, Integer> original) {
		return HashMultimap.create(original);
	}

}
