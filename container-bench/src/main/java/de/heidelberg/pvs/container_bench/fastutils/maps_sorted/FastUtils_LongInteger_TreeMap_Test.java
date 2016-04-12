package de.heidelberg.pvs.container_bench.fastutils.maps_sorted;

import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import it.unimi.dsi.fastutil.objects.Object2ObjectAVLTreeMap;

public class FastUtils_LongInteger_TreeMap_Test extends AbstractJDKMapTest<Long , Integer>{

	@Override
	protected Map<Long, Integer> getNewMap(int size, int range) {
		return new Object2ObjectAVLTreeMap<>();
	}

	@Override
	protected Map<Long, Integer> copyMap(Map<Long, Integer> fullMap2) {
		return new Object2ObjectAVLTreeMap<>(fullMap2);
	}

	@Override
	protected RandomGenerator<Long> instantiateRandomKeyGenerator() {
		return new LongRandomGenerator();
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomValueGenerator() {
		return new IntegerRandomGenerator();
	}

}
