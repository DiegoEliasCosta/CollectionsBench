package de.heidelberg.pvs.container_bench.gscollections.maps;

import java.util.Map;

import com.gs.collections.impl.map.mutable.UnifiedMap;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class GSCollections_LongInteger_UnifiedMaps_Test extends AbstractJDKMapTest<Long, Integer>{

	@Override
	protected Map<Long, Integer> getNewMap(int size, int range) {
		return new UnifiedMap<Long, Integer>();
	}

	@Override
	protected Map<Long, Integer> copyMap(Map<Long, Integer> fullMap2) {
		return new UnifiedMap<Long, Integer>(fullMap2);
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
