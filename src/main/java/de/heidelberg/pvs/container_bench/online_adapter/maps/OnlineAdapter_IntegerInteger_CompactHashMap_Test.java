package de.heidelberg.pvs.container_bench.online_adapter.maps;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import vlsi.utils.CompactHashMap;

public class OnlineAdapter_IntegerInteger_CompactHashMap_Test extends AbstractJDKMapTest<Integer, Integer> {

	@Override
	protected Map<Integer, Integer> getNewMap() {
		return new CompactHashMap<>();
	}

	@Override
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		CompactHashMap<Integer, Integer> compactHashMap = new CompactHashMap<>();
		compactHashMap.putAll(fullMap2);
		return compactHashMap;
	}

}
