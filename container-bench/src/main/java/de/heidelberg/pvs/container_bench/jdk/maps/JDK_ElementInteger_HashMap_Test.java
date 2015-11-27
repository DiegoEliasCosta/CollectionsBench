package de.heidelberg.pvs.container_bench.jdk.maps;

import java.util.HashMap;
import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import de.heidelberg.pvs.container_bench.element.Element;
import de.heidelberg.pvs.container_bench.random.ElementRandomGenerator;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_ElementInteger_HashMap_Test extends AbstractJDKMapTest<Element, Integer>{

	@Override
	protected Map<Element, Integer> getNewMap(int size, int range) {
		return new HashMap<Element, Integer>();
	}

	@Override
	protected Map<Element, Integer> copyMap(Map<Element, Integer> fullMap2) {
		return new HashMap<Element, Integer>(fullMap2);
	}

	@Override
	protected RandomGenerator<Element> instantiateRandomKeyGenerator() {
		return new ElementRandomGenerator();
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomValueGenerator() {
		return new IntegerRandomGenerator();
	}

}
