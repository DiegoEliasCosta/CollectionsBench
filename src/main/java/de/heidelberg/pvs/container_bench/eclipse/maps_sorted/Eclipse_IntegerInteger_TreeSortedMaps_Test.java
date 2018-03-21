package de.heidelberg.pvs.container_bench.eclipse.maps_sorted;

import java.util.Map;

import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;

public class Eclipse_IntegerInteger_TreeSortedMaps_Test extends AbstractJDKMapTest<Integer, Integer>{

	@Override
	protected Map<Integer, Integer> getNewMap() {
		return new TreeSortedMap<Integer, Integer>();
	}

	@Override
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		return new TreeSortedMap<Integer, Integer>(fullMap2);
	}

}
