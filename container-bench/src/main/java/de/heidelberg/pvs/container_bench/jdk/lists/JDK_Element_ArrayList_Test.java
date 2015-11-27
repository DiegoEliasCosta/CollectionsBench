package de.heidelberg.pvs.container_bench.jdk.lists;

import java.util.ArrayList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import de.heidelberg.pvs.container_bench.element.Element;
import de.heidelberg.pvs.container_bench.random.ElementRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_Element_ArrayList_Test extends AbstractJDKListTest<Element> {
	

	@Override
	protected List<Element> getNewList(int size) {
		return new ArrayList<Element>();
	}

	@Override
	protected List<Element> copyList(List<Element> fullList2) {
		return new ArrayList<Element>(fullList2);
	}

	@Override
	protected RandomGenerator<Element> instantiateRandomGenerator() {
		return new ElementRandomGenerator();
	}

}
