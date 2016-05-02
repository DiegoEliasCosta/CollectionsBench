package de.heidelberg.pvs.container_bench.fastutils.maps_p;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import it.unimi.dsi.fastutil.ints.Int2IntAVLTreeMap;

public class FastUtils_IntegerInteger_PTreeMap_Test extends AbstractJDKMapTest<Integer , Integer>{

	@Override
	protected Map<Integer, Integer> getNewMap(int size, int range) {
		return new Int2IntAVLTreeMap();
	}

	@Override
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		return new Int2IntAVLTreeMap(fullMap2);
	}

}
