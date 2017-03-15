package de.heidelberg.pvs.container_bench.online_adapter.lists;

import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import de.heidelberg.pvs.diego.collections_online_adapter.context.ListAllocationContextStub;
import de.heidelberg.pvs.diego.collections_online_adapter.instrumenters.lists.ArrayListSizeMonitor;

public class OnlineAdapter_Integer_ArrayListSizeMonitor_Test extends AbstractJDKListTest<Integer> {

	@Override
	protected List<Integer> getNewList() {
		return new ArrayListSizeMonitor<Integer>(new ListAllocationContextStub<Integer>());
	}

	@Override
	protected List<Integer> copyList(List<Integer> fullList2) {
		return new ArrayListSizeMonitor<Integer>(fullList2, new ListAllocationContextStub<Integer>());
	}

}
