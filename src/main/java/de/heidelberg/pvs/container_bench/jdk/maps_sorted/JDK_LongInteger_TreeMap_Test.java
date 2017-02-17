package de.heidelberg.pvs.container_bench.jdk.maps_sorted;

import java.util.Map;
import java.util.TreeMap;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;

public class JDK_LongInteger_TreeMap_Test extends AbstractJDKMapTest<Long, Integer>{

	@Override
	protected Map<Long, Integer> getNewMap(int size, int range) {
		return new TreeMap<Long, Integer>();
	}


	@Override
	protected Map<Long, Integer> copyMap(Map<Long, Integer> fullMap2) {
		return new TreeMap<Long, Integer>(fullMap2);
	}

}
