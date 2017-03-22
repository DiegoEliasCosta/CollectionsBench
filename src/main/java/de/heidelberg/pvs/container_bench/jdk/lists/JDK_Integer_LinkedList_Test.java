package de.heidelberg.pvs.container_bench.jdk.lists;

import java.util.LinkedList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;

public class JDK_Integer_LinkedList_Test extends AbstractJDKListTest<Integer> {

	@Override
	protected List<Integer> getNewList() {
		return new LinkedList<Integer>();
	}

	@Override
	protected List<Integer> copyList(List<Integer> fullList2) {
		return new LinkedList<Integer>(fullList2);
	}
	

}
