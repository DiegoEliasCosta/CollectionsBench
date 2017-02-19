package de.heidelberg.pvs.container_bench.fastutils.maps;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

public class FastUtils_IntegerInteger_OpenHashMap_Test extends AbstractJDKMapTest<Integer, Integer> {

	@Override
	protected Map<Integer, Integer> getNewMap(int size, int range) {
		return new Object2ObjectOpenHashMap<>();
	}

	@Override
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		return new Object2ObjectOpenHashMap<>(fullMap2);
	}

}