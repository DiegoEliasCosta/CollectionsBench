package de.heidelberg.pvs.container_bench.jdk.maps;

import java.util.HashMap;
import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;

public class JDK_ObjectInteger_HashMap_Test extends AbstractJDKMapTest<Object, Integer> {

	@Override
	protected Map<Object, Integer> getNewMap(int size, int range) {
		return new HashMap<Object, Integer>();
	}

	@Override
	protected int generateRandomIndex(int size) {
		return randomGenerator.generateIntegerInRange(size);
	}

	@Override
	protected Object[] generateRandomKeys(int size, int range) {
		return randomGenerator.generateElements(size); // range makes no sense here
	}

	@Override
	protected Object generateRandomKey(int range) {
		return randomGenerator.generateElement(); //range makes no sense here
	}

	@Override
	protected Integer[] generateRandomValues(int size) {
		return randomGenerator.generateIntegers(size); // range makes no sense for values
	}

	@Override
	protected Integer generateRandomValue() {
		return randomGenerator.generateInteger();
	}

	@Override
	protected Map<Object, Integer> copyMap(Map<Object, Integer> fullMap2) {
		return new HashMap<Object, Integer>(fullMap2);
	}

}
