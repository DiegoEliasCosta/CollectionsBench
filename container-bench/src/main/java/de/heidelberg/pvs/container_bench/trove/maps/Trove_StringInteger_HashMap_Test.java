package de.heidelberg.pvs.container_bench.trove.maps;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;
import gnu.trove.map.hash.TCustomHashMap;
import gnu.trove.strategy.IdentityHashingStrategy;

public class Trove_StringInteger_HashMap_Test extends AbstractJDKMapTest<String, Integer> {

	@Override
	protected Map<String, Integer> getNewMap(int size, int range) {
		// FIXME: Check the use of Identity Hashing Strategy
		return new TCustomHashMap<>(new IdentityHashingStrategy<>()); 
	}

	@Override
	protected Map<String, Integer> copyMap(Map<String, Integer> fullMap2) {
		return new TCustomHashMap<>(new IdentityHashingStrategy<>(), fullMap2);
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
