package de.heidelberg.pvs.container_bench.fastutils.maps_sorted;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import it.unimi.dsi.fastutil.ints.Int2IntAVLTreeMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;

public class FastUtils_StringInteger_TreeMap_Test extends AbstractJDKMapTest<Integer , Integer>{

	@Override
	protected Map<Integer, Integer> getNewMap(int size, int range) {
		return new Object2ObjectArrayMap<>();
	}

	@Override
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		return new Int2IntAVLTreeMap(fullMap2);
	}

}
