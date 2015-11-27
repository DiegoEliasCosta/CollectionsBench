package de.heidelberg.pvs.container_bench.jdk.lists;

import java.util.LinkedList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;

public class JDK_String_Vector_Test extends AbstractJDKListTest<String> {

	@Override
	protected List<String> getNewList(int size) {
		return new LinkedList<String>();
	}

	@Override
	protected List<String> copyList(List<String> fullList2) {
		return new LinkedList<String>(fullList2);
	}

	@Override
	protected RandomGenerator<String> instantiateRandomGenerator() {
		return new StringRandomGenerator();
	}

}
