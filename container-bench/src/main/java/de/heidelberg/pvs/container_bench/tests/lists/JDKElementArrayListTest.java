package de.heidelberg.pvs.container_bench.tests.lists;

import java.util.ArrayList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.AbstractJDKListTest;
import de.heidelberg.pvs.container_bench.element.Element;

public class JDKElementArrayListTest extends AbstractJDKListTest<Element> {

	@Override
	protected Element[] generateRandomArray(int size) {
		return randomGenerator.generateElements(size);
	}

	@Override
	protected Integer generateRandomIndex(int size) {
		return randomGenerator.generateIntegerInRange(size);
	}

	@Override
	protected List<Element> getNewList(int size) {
		return new ArrayList<Element>(size);
	}

	@Override
	protected List<Element> copyList(List<Element> fullList2) {
		return new ArrayList<Element>(fullList2);
	}

}
