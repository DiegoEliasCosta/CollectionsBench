package de.heidelberg.pvs.container_bench.google.maps;

import java.util.Map;

import com.google.api.client.util.ArrayMap;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;

public class Google_IntegerInteger_ArrayMap_Test extends AbstractJDKMapTest<Integer, Integer> {

	@Override
	protected Map<Integer, Integer> getNewMap() {
		return new ArrayMap<Integer, Integer>();
	}

	@Override
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		// The google ArrayMap does not provide an API for copying
		ArrayMap<Integer,Integer> arrayMap = new ArrayMap<Integer, Integer>();
		arrayMap.putAll(fullMap2);
		return arrayMap;
	}

}
