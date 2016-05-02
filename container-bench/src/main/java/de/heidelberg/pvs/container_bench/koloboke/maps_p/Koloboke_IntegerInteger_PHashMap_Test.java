package de.heidelberg.pvs.container_bench.koloboke.maps_p;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import net.openhft.koloboke.collect.map.hash.HashIntIntMaps;

public class Koloboke_IntegerInteger_PHashMap_Test extends AbstractJDKMapTest<Integer, Integer> {

	@Override
	protected Map<Integer, Integer> getNewMap(int size, int range) {
		return HashIntIntMaps.newMutableMap();
	}

	@Override
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		return HashIntIntMaps.newMutableMap(fullMap2);
	}

}
