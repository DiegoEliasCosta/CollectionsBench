package de.heidelberg.pvs.container_bench.jdk.lists;

import java.util.ArrayList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;

public class JDK_Integer_ArrayList_Test extends AbstractJDKListTest<Integer> {
	
	
	@Override
	protected List<Integer> getNewList(int size) {
		return new ArrayList<Integer>();
	}

	@Override
	protected List<Integer> copyList(List<Integer> fullList2) {
		return new ArrayList<Integer>(fullList2);
	}

}
