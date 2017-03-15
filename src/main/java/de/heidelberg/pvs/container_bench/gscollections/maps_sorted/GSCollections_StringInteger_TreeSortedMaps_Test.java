package de.heidelberg.pvs.container_bench.gscollections.maps_sorted;

import java.util.Map;

import com.gs.collections.impl.map.sorted.mutable.TreeSortedMap;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;

public class GSCollections_StringInteger_TreeSortedMaps_Test extends AbstractJDKMapTest<String, Integer>{

	@Override
	protected Map<String, Integer> getNewMap() {
		return new TreeSortedMap<String, Integer>();
	}

	@Override
	protected Map<String, Integer> copyMap(Map<String, Integer> fullMap2) {
		return new TreeSortedMap<String, Integer>(fullMap2);
	}


}
