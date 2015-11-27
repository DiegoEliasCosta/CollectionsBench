package de.heidelberg.pvs.container_bench.jdk.lists;

import java.util.LinkedList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import de.heidelberg.pvs.container_bench.element.Element;
import de.heidelberg.pvs.container_bench.random.ElementRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_Element_LinkedList_Test extends AbstractJDKListTest<Element>{

	@Override
	protected List<Element> getNewList(int size) {
		return new LinkedList<Element>();
	}

	@Override
	protected List<Element> copyList(List<Element> fullList2) {
		return new LinkedList<Element>(fullList2);
	}

	@Override
	protected RandomGenerator<Element> instantiateRandomGenerator() {
		return new ElementRandomGenerator();
	}

}
