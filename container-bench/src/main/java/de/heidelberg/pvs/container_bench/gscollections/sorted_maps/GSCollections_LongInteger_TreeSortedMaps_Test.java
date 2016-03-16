package de.heidelberg.pvs.container_bench.gscollections.sorted_maps;

import java.util.Map;

import com.gs.collections.impl.map.sorted.mutable.TreeSortedMap;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class GSCollections_LongInteger_TreeSortedMaps_Test extends AbstractJDKMapTest<Long, Integer>{

	@Override
	protected Map<Long, Integer> getNewMap(int size, int range) {
		return new TreeSortedMap<Long, Integer>();
	}

	@Override
	protected Map<Long, Integer> copyMap(Map<Long, Integer> fullMap2) {
		return new TreeSortedMap<Long, Integer>(fullMap2);
	}

	@Override
	protected RandomGenerator<Long> instantiateRandomKeyGenerator() {
		return new LongRandomGenerator();
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomValueGenerator() {
		return new IntegerRandomGenerator();
	}

}
