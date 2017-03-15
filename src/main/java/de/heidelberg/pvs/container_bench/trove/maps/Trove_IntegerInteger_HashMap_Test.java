package de.heidelberg.pvs.container_bench.trove.maps;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import gnu.trove.map.hash.THashMap;

public class Trove_IntegerInteger_HashMap_Test extends AbstractJDKMapTest<Integer, Integer> {

	@Override
	protected Map<Integer, Integer> getNewMap() {
		// FIXME: Check the use of Identity Hashing Strategy
		return new THashMap<Integer, Integer>(); 
	}

	@Override
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		return new THashMap<>(fullMap2);
	}

}
