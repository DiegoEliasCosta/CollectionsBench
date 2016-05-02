package de.heidelberg.pvs.container_bench.koloboke.maps_p;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import net.openhft.koloboke.collect.map.hash.HashLongIntMaps;

public class Koloboke_LongInteger_PHashMap_Test extends AbstractJDKMapTest<Long, Integer> {

	@Override
	protected Map<Long, Integer> getNewMap(int size, int range) {
		return HashLongIntMaps.newMutableMap();
	}

	@Override
	protected Map<Long, Integer> copyMap(Map<Long, Integer> fullMap2) {
		return HashLongIntMaps.newMutableMap(fullMap2);
	}

}
