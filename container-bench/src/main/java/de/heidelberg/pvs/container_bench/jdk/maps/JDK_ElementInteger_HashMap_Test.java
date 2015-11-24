package de.heidelberg.pvs.container_bench.jdk.maps;

import java.util.HashMap;
import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKMapTest;
import de.heidelberg.pvs.container_bench.element.Element;

public class JDK_ElementInteger_HashMap_Test extends AbstractJDKMapTest<Element, Integer>{

	@Override
	protected Map<Element, Integer> getNewMap(int size, int range) {
		return new HashMap<Element, Integer>();
	}

	@Override
	protected int generateRandomIndex(int size) {
		return randomGenerator.generateIntegerInRange(size);
	}

	@Override
	protected Element[] generateRandomKeys(int size, int range) {
		return randomGenerator.generateElements(size);
	}

	@Override
	protected Element generateRandomKey(int range) {
		return randomGenerator.generateElement();
	}

	@Override
	protected Integer[] generateRandomValues(int size, int range) {
		return randomGenerator.generateIntegers(size); // range makes no sense for values
	}

	@Override
	protected Integer generateRandomValue(int range) {
		return randomGenerator.generateInteger();
	}

	@Override
	protected Map<Element, Integer> copyMap(Map<Element, Integer> fullMap2) {
		return new HashMap<Element, Integer>(fullMap2);
	}

}
