package de.heidelberg.pvs.container_bench.jdk.sets;

import java.util.HashSet;
import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.element.Element;
import de.heidelberg.pvs.container_bench.random.ElementRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_Element_HashSet_Test extends AbstractJDKSetTest<Element> {

	@Override
	protected Set<Element> getNewSet(int size) {
		return new HashSet<Element>();
	}

	@Override
	protected Set<Element> copySet(Set<Element> fullSet2) {
		return new HashSet<Element>(fullSet2);
	}

	@Override
	protected RandomGenerator<Element> instantiateRandomGenerator() {
		return new ElementRandomGenerator();
	}


}
