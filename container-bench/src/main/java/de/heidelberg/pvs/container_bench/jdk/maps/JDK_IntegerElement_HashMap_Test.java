package de.heidelberg.pvs.container_bench.jdk.maps;

import java.util.HashMap;
import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import de.heidelberg.pvs.container_bench.element.Element;

public class JDK_IntegerElement_HashMap_Test extends AbstractJDKMapTest<Integer, Element> {

	@Override
	protected Map<Integer, Element> getNewMap(int size, int range) {
		return new HashMap<>();
	}

	@Override
	protected int generateRandomIndex(int size) {
		return randomGenerator.generateIntegerInRange(size);
	}

	@Override
	protected Integer[] generateRandomKeys(int size, int range) {
		return randomGenerator.generateIntegersInRange(size, range);
	}

	@Override
	protected Integer generateRandomKey(int range) {
		return randomGenerator.generateIntegerInRange(range);
	}

	@Override
	protected Element[] generateRandomValues(int size) {
		return randomGenerator.generateElements(size); 
	}

	@Override
	protected Element generateRandomValue() {
		return randomGenerator.generateElement();
	}

	@Override
	protected Map<Integer, Element> copyMap(Map<Integer, Element> fullMap2) {
		return new HashMap<>(fullMap2);
	}

}
