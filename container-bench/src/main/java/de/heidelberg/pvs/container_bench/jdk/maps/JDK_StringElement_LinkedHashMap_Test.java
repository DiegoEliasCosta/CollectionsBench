package de.heidelberg.pvs.container_bench.jdk.maps;

import java.util.LinkedHashMap;
import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import de.heidelberg.pvs.container_bench.element.Element;
import de.heidelberg.pvs.container_bench.random.ElementRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;

public class JDK_StringElement_LinkedHashMap_Test extends AbstractJDKMapTest<String, Element>{

	@Override
	protected Map<String, Element> getNewMap(int size, int range) {
		return new LinkedHashMap<String, Element>();
	}


	@Override
	protected Map<String, Element> copyMap(Map<String, Element> fullMap2) {
		return new LinkedHashMap<>();
	}


	@Override
	protected RandomGenerator<String> instantiateRandomKeyGenerator() {
		return new StringRandomGenerator();
	}


	@Override
	protected RandomGenerator<Element> instantiateRandomValueGenerator() {
		return new ElementRandomGenerator();
	}

}
