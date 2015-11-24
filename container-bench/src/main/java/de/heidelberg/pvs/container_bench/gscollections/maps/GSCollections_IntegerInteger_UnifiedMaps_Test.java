package de.heidelberg.pvs.container_bench.gscollections.maps;

import java.util.Map;

import com.gs.collections.impl.map.mutable.UnifiedMap;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;

public class GSCollections_IntegerInteger_UnifiedMaps_Test extends AbstractJDKMapTest<Integer, Integer>{

	@Override
	protected Map<Integer, Integer> getNewMap(int size, int range) {
		return new UnifiedMap<Integer, Integer>();
	}

	@Override
	protected int generateRandomIndex(int size) {
		return this.randomGenerator.generateIntegerInRange(size);
	}

	@Override
	protected Integer[] generateRandomKeys(int size, int range) {
		return randomGenerator.generateIntegersInRange(size, range);
	}

	@Override
	protected Integer generateRandomKey(int range) {
		return randomGenerator.generateIntegerInRange(range);
	}

	@Override
	protected Integer[] generateRandomValues(int size) {
		return randomGenerator.generateIntegers(size);
	}

	@Override
	protected Integer generateRandomValue() {
		return randomGenerator.generateInteger();
	}

	@Override
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		return new UnifiedMap<Integer, Integer>(fullMap2);
	}

}
