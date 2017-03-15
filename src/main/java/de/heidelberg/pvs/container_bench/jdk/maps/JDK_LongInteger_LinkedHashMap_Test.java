package de.heidelberg.pvs.container_bench.jdk.maps;

import java.util.LinkedHashMap;
import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;

public class JDK_LongInteger_LinkedHashMap_Test extends AbstractJDKMapTest<Long, Integer>{

	@Override
	protected Map<Long, Integer> getNewMap() {
		return new LinkedHashMap<Long, Integer>();
	}


	@Override
	protected Map<Long, Integer> copyMap(Map<Long, Integer> fullMap2) {
		return new LinkedHashMap<>(fullMap2);
	}

}
