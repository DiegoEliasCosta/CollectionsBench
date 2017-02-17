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
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		return new UnifiedMap<Integer, Integer>(fullMap2);
	}

}
