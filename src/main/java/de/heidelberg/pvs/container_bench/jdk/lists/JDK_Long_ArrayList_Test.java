package de.heidelberg.pvs.container_bench.jdk.lists;

import java.util.ArrayList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;

public class JDK_Long_ArrayList_Test extends AbstractJDKListTest<Long> {
	

	@Override
	protected List<Long> getNewList(int size) {
		return new ArrayList<Long>();
	}

	@Override
	protected List<Long> copyList(List<Long> fullList2) {
		return new ArrayList<Long>(fullList2);
	}
}
