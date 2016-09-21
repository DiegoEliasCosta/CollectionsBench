package de.heidelberg.pvs.container_bench.trove.maps;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import gnu.trove.map.hash.THashMap;

public class Trove_LongInteger_HashMap_Test extends AbstractJDKMapTest<Long, Integer> {

	@Override
	protected Map<Long, Integer> getNewMap(int size, int range) {
		// FIXME: Check the use of Identity Hashing Strategy
		return new THashMap<>(); 
	}

	@Override
	protected Map<Long, Integer> copyMap(Map<Long, Integer> fullMap2) {
		return new THashMap<>(fullMap2);
	}


}
