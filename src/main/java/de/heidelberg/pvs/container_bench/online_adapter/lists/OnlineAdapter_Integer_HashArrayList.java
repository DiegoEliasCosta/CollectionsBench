package de.heidelberg.pvs.container_bench.online_adapter.lists;

import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import de.heidelberg.pvs.diego.collections_online_adapter.custom.HashArrayList;

public class OnlineAdapter_Integer_HashArrayList extends AbstractJDKListTest<Integer> {

	@Override
	protected List<Integer> getNewList() {
		return new HashArrayList<>();
	}

	@Override
	protected List<Integer> copyList(List<Integer> fullList2) {
		return new HashArrayList<>(fullList2);
	}

}
