package de.heidelberg.pvs.container_bench.fastutils.maps_sorted;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapBench;
import it.unimi.dsi.fastutil.objects.Object2ObjectAVLTreeMap;

public class FastUtils_LongInteger_AVLTreeMap_Test extends AbstractJDKMapBench<Long , Integer>{

	@Override
	protected Map<Long, Integer> getNewMap() {
		return new Object2ObjectAVLTreeMap<>();
	}

	@Override
	protected Map<Long, Integer> copyMap(Map<Long, Integer> fullMap2) {
		return new Object2ObjectAVLTreeMap<>(fullMap2);
	}

}
