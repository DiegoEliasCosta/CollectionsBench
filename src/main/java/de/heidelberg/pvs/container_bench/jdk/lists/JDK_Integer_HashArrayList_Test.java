package de.heidelberg.pvs.container_bench.jdk.lists;

import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import de.heidelberg.pvs.diego.collections_online_adapter.custom.HashArrayList;

public class JDK_Integer_HashArrayList_Test extends AbstractJDKListTest<Integer> {

	@Override
	protected List<Integer> getNewList() {
		return new HashArrayList<Integer>();
	}

	@Override
	protected List<Integer> copyList(List<Integer> fullList2) {
		return new HashArrayList<Integer>(fullList2);
	}

}
