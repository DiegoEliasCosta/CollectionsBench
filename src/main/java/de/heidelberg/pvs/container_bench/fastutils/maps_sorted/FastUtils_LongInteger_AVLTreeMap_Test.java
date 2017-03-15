package de.heidelberg.pvs.container_bench.fastutils.maps_sorted;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import it.unimi.dsi.fastutil.objects.Object2ObjectAVLTreeMap;

public class FastUtils_LongInteger_AVLTreeMap_Test extends AbstractJDKMapTest<Long , Integer>{

	@Override
	protected Map<Long, Integer> getNewMap() {
		return new Object2ObjectAVLTreeMap<>();
	}

	@Override
	protected Map<Long, Integer> copyMap(Map<Long, Integer> fullMap2) {
		return new Object2ObjectAVLTreeMap<>(fullMap2);
	}

}
