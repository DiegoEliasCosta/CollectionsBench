package de.heidelberg.pvs.container_bench.gscollections.maps;

import java.util.Map;

import com.gs.collections.impl.map.mutable.UnifiedMap;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;

public class GSCollections_StringInteger_UnifiedMaps_Test extends AbstractJDKMapTest<String, Integer>{

	@Override
	protected Map<String, Integer> getNewMap(int size, int range) {
		return new UnifiedMap<String, Integer>();
	}

	@Override
	protected Map<String, Integer> copyMap(Map<String, Integer> fullMap2) {
		return new UnifiedMap<String, Integer>(fullMap2);
	}

}
