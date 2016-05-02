package de.heidelberg.pvs.container_bench.fastutils.maps_sorted_p;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import it.unimi.dsi.fastutil.longs.Long2IntAVLTreeMap;

public class FastUtils_LongInteger_PTreeMap_Test extends AbstractJDKMapTest<Long , Integer>{

	@Override
	protected Map<Long, Integer> getNewMap(int size, int range) {
		return new Long2IntAVLTreeMap();
	}

	@Override
	protected Map<Long, Integer> copyMap(Map<Long, Integer> fullMap2) {
		return new Long2IntAVLTreeMap(fullMap2);
	}

}
