package de.heidelberg.pvs.container_bench.jdk.sets;

import java.util.Set;
import java.util.TreeSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.element.Element;

public class JDK_Element_TreeSet_Test extends AbstractJDKSetTest<Element> {

	@Override
	protected Element[] generateUniqueRandomArray(int size) {
		return randomGenerator.generateElements(size);
	}

	@Override
	protected Integer generateRandomIndex(int size) {
		return randomGenerator.generateIntegerInRange(size);
	}

	@Override
	protected Set<Element> getNewSet(int size) {
		return new TreeSet<Element>();
	}

	@Override
	protected Set<Element> copySet(Set<Element> fullSet2) {
		return new TreeSet<>(fullSet2);
	}

}
