package de.heidelberg.pvs.container_bench.trove.maps;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import gnu.trove.map.hash.TCustomHashMap;
import gnu.trove.strategy.IdentityHashingStrategy;

public class Trove_IntegerInteger_HashMap_Test extends AbstractJDKMapTest<Integer, Integer> {

	@Override
	protected Map<Integer, Integer> getNewMap(int size, int range) {
		// FIXME: Check the use of Identity Hashing Strategy
		return new TCustomHashMap<Integer, Integer>(new IdentityHashingStrategy<>()); 
	}

	@Override
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		return new TCustomHashMap<>(new IdentityHashingStrategy<>(), fullMap2);
	}

}
