package de.heidelberg.pvs.container_bench.jdk.maps_sorted;

import java.util.Map;
import java.util.TreeMap;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;

public class JDK_StringInteger_TreeMap_Test extends AbstractJDKMapTest<String, Integer>{

	@Override
	protected Map<String, Integer> getNewMap(int size, int range) {
		return new TreeMap<String, Integer>();
	}


	@Override
	protected Map<String, Integer> copyMap(Map<String, Integer> fullMap2) {
		return new TreeMap<String, Integer>(fullMap2);
	}

}
