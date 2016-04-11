package de.heidelberg.pvs.container_bench.gscollections.maps_sorted;

import java.util.Map;

import com.gs.collections.impl.map.sorted.mutable.TreeSortedMap;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;

public class GSCollections_StringInteger_TreeSortedMaps_Test extends AbstractJDKMapTest<String, Integer>{

	@Override
	protected Map<String, Integer> getNewMap(int size, int range) {
		return new TreeSortedMap<String, Integer>();
	}

	@Override
	protected Map<String, Integer> copyMap(Map<String, Integer> fullMap2) {
		return new TreeSortedMap<String, Integer>(fullMap2);
	}

	@Override
	protected RandomGenerator<String> instantiateRandomKeyGenerator() {
		return new StringRandomGenerator();
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomValueGenerator() {
		return new IntegerRandomGenerator();
	}

}
