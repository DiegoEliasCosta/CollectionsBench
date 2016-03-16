package de.heidelberg.pvs.container_bench.jdk.maps.initialCapacity;

import java.util.HashMap;
import java.util.Map;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_LongInteger_HashMap_Test extends AbstractJDKMapTest<Long, Integer> {

	@Param({ "0", "25", "50", "75", "100", "125", "150"})
	public int initialCapacityRatio;
	
	@Override
	protected Map<Long, Integer> getNewMap(int size, int range) {
		int realSize = (int) (size * (double) (initialCapacityRatio/100));
		return new HashMap<>(realSize);
	}

	@Override
	protected Map<Long, Integer> copyMap(Map<Long, Integer> fullMap2) {
		return new HashMap<>(fullMap2);
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
