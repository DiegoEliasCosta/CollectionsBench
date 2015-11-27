package de.heidelberg.pvs.container_bench.jdk.maps;

import java.util.HashMap;
import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import de.heidelberg.pvs.container_bench.element.Element;
import de.heidelberg.pvs.container_bench.random.ElementRandomGenerator;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_IntegerElement_HashMap_Test extends AbstractJDKMapTest<Integer, Element> {

	@Override
	protected Map<Integer, Element> getNewMap(int size, int range) {
		return new HashMap<>();
	}

	@Override
	protected Map<Integer, Element> copyMap(Map<Integer, Element> fullMap2) {
		return new HashMap<>(fullMap2);
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomKeyGenerator() {
		return new IntegerRandomGenerator();
	}

	@Override
	protected RandomGenerator<Element> instantiateRandomValueGenerator() {
		return new ElementRandomGenerator();
	}
	
	

}
