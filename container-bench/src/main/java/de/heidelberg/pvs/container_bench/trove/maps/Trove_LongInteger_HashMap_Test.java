package de.heidelberg.pvs.container_bench.trove.maps;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import gnu.trove.map.hash.TCustomHashMap;
import gnu.trove.strategy.IdentityHashingStrategy;

public class Trove_LongInteger_HashMap_Test extends AbstractJDKMapTest<Long, Integer> {

	@Override
	protected Map<Long, Integer> getNewMap(int size, int range) {
		// FIXME: Check the use of Identity Hashing Strategy
		return new TCustomHashMap<>(new IdentityHashingStrategy<>()); 
	}

	@Override
	protected Map<Long, Integer> copyMap(Map<Long, Integer> fullMap2) {
		return new TCustomHashMap<>(new IdentityHashingStrategy<>(), fullMap2);
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
