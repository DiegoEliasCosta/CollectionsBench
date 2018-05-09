package de.heidelberg.pvs.container_bench.guava.maps;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import de.heidelberg.pvs.container_bench.abstracts.guava.AbstractGuavaMultiMapBench;

public class Guava_LongInteger_HashMultimap_Test extends AbstractGuavaMultiMapBench<Long, Integer> {

	@Override
	protected Multimap<Long, Integer> getNewMultiMap(int size, int rangeOfKeys) {
		return HashMultimap.create();
	}

	@Override
	protected Multimap<Long, Integer> copyMultiMap(Multimap<Long, Integer> original) {
		return HashMultimap.create(original);
	}

}
