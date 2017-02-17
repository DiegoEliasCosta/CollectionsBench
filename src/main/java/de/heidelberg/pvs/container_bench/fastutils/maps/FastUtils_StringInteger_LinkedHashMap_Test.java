package de.heidelberg.pvs.container_bench.fastutils.maps;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;

public class FastUtils_StringInteger_LinkedHashMap_Test extends AbstractJDKMapTest<String, Integer>{

	@Override
	protected Map<String, Integer> getNewMap(int size, int range) {
		return new Object2ObjectLinkedOpenHashMap<String, Integer>();
	}

	@Override
	protected Map<String, Integer> copyMap(Map<String, Integer> fullMap2) {
		return new Object2ObjectLinkedOpenHashMap<String, Integer>(fullMap2);
	}

}
