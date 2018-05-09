package de.heidelberg.pvs.container_bench.fastutils.maps_sorted;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapBench;
import it.unimi.dsi.fastutil.objects.Object2ObjectAVLTreeMap;

public class FastUtils_StringInteger_AVLTreeMap_Test extends AbstractJDKMapBench<String, Integer>{

	@Override
	protected Map<String, Integer> getNewMap() {
		return new Object2ObjectAVLTreeMap<>();
	}

	@Override
	protected Map<String, Integer> copyMap(Map<String, Integer> fullMap2) {
		return new Object2ObjectAVLTreeMap<>(fullMap2);
	}

}
