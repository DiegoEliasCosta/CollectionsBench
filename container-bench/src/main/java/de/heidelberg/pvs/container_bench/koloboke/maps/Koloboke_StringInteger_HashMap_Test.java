package de.heidelberg.pvs.container_bench.koloboke.maps;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;
import net.openhft.koloboke.collect.map.hash.HashObjObjMaps;

public class Koloboke_StringInteger_HashMap_Test extends AbstractJDKMapTest<String, Integer> {

	@Override
	protected Map<String, Integer> getNewMap(int size, int range) {
		return HashObjObjMaps.newMutableMap();
	}

	@Override
	protected Map<String, Integer> copyMap(Map<String, Integer> fullMap2) {
		return HashObjObjMaps.newMutableMap(fullMap2);
	}

	@Override
	protected RandomGenerator<String> instantiateRandomKeyGenerator() {
		return new StringRandomGenerator();
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomValueGenerator() {
		return new IntegerRandomGenerator();
	}

}
