package de.heidelberg.pvs.container_bench.eclipse.maps_sorted;

import java.util.Map;

import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;

public class Eclipse_LongInteger_TreeSortedMaps_Test extends AbstractJDKMapTest<Long, Integer>{

	@Override
	protected Map<Long, Integer> getNewMap() {
		return new TreeSortedMap<Long, Integer>();
	}

	@Override
	protected Map<Long, Integer> copyMap(Map<Long, Integer> fullMap2) {
		return new TreeSortedMap<Long, Integer>(fullMap2);
	}

}
