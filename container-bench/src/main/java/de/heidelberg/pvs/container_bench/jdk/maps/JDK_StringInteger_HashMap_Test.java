package de.heidelberg.pvs.container_bench.jdk.maps;

import java.util.HashMap;
import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;

public class JDK_StringInteger_HashMap_Test extends AbstractJDKMapTest<String, Integer> {

	@Override
	protected Map<String, Integer> getNewMap(int size, int range) {
		return new HashMap<String, Integer>();
	}

	@Override
	protected int generateRandomIndex(int size) {
		return randomGenerator.generateIntegerInRange(size);
	}

	@Override
	protected String[] generateRandomKeys(int size, int range) {
		return randomGenerator.generateStrings(size); // We're not using range. 
	}

	@Override
	protected String generateRandomKey(int range) {
		return randomGenerator.generateString();
	}

	@Override
	protected Integer[] generateRandomValues(int size) {
		return randomGenerator.generateIntegers(size); // The range here is irrelevant
	}

	@Override
	protected Integer generateRandomValue() {
		return randomGenerator.generateInteger();
	}

	@Override
	protected Map<String, Integer> copyMap(Map<String, Integer> fullMap2) {
		return new HashMap<String, Integer>(fullMap2);
	}

}