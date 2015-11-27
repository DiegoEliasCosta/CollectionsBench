package de.heidelberg.pvs.container_bench.jdk.lists;

import java.util.List;
import java.util.Vector;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import de.heidelberg.pvs.container_bench.element.Element;
import de.heidelberg.pvs.container_bench.random.ElementRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class JDK_Element_Vector_Test extends AbstractJDKListTest<Element> {

	@Override
	protected List<Element> getNewList(int size) {
		return new Vector<Element>();
	}

	@Override
	protected List<Element> copyList(List<Element> fullList2) {
		return new Vector<Element>(fullList2);
	}

	@Override
	protected RandomGenerator<Element> instantiateRandomGenerator() {
		return new ElementRandomGenerator();
	}

}
