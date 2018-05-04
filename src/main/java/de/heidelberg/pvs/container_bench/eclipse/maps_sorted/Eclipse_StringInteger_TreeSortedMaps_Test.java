package de.heidelberg.pvs.container_bench.eclipse.maps_sorted;

import java.util.Map;

import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;

public class Eclipse_StringInteger_TreeSortedMaps_Test extends AbstractJDKMapTest<String, Integer>{

	@Override
	protected Map<String, Integer> getNewMap() {
		return new TreeSortedMap<String, Integer>();
	}

	@Override
	protected Map<String, Integer> copyMap(Map<String, Integer> fullMap2) {
		return new TreeSortedMap<String, Integer>(fullMap2);
	}


}
