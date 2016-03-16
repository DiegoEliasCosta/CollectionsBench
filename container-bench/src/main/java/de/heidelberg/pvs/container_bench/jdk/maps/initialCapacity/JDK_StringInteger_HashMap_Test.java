package de.heidelberg.pvs.container_bench.jdk.maps.initialCapacity;

import java.util.HashMap;
import java.util.Map;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;

public class JDK_StringInteger_HashMap_Test extends AbstractJDKMapTest<String, Integer> {

	@Param({ "0", "25", "50", "75", "100", "125", "150"})
	public int initialCapacityRatio;
	
	@Override
	protected Map<String, Integer> getNewMap(int size, int range) {
		int realSize = (int) (size * (double) (initialCapacityRatio/100));
		return new HashMap<>(realSize);
	}

	@Override
	protected Map<String, Integer> copyMap(Map<String, Integer> fullMap2) {
		return new HashMap<String, Integer>(fullMap2);
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