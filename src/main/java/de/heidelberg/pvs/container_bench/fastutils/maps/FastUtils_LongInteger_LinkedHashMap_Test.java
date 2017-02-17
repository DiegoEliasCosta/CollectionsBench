package de.heidelberg.pvs.container_bench.fastutils.maps;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;

public class FastUtils_LongInteger_LinkedHashMap_Test extends AbstractJDKMapTest<Long, Integer> {

	@Override
	protected Map<Long, Integer> getNewMap(int size, int range) {
		return new Object2ObjectLinkedOpenHashMap<>();
	}

	@Override
	protected Map<Long, Integer> copyMap(Map<Long, Integer> fullMap2) {
		return new Object2ObjectLinkedOpenHashMap<>(fullMap2);
	}


}
