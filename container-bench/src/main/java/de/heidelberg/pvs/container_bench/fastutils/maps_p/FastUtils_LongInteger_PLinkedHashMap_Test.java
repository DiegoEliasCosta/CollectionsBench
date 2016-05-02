package de.heidelberg.pvs.container_bench.fastutils.maps_p;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import it.unimi.dsi.fastutil.longs.Long2IntLinkedOpenHashMap;

public class FastUtils_LongInteger_PLinkedHashMap_Test extends AbstractJDKMapTest<Long, Integer> {

	@Override
	protected Map<Long, Integer> getNewMap(int size, int range) {
		return new Long2IntLinkedOpenHashMap();
	}

	@Override
	protected Map<Long, Integer> copyMap(Map<Long, Integer> fullMap2) {
		return new Long2IntLinkedOpenHashMap(fullMap2);
	}

}
