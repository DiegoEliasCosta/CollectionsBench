package de.heidelberg.pvs.container_bench.online_adapter.lists;

import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import de.heidelberg.pvs.diego.collections_online_adapter.context.CollectionTypeEnum;
import de.heidelberg.pvs.diego.collections_online_adapter.context.ListAllocationContext;
import de.heidelberg.pvs.diego.collections_online_adapter.context.impl.ListAllocationContextImpl;

public class OnlineAdapter_Integer_MemoryOptimizedList_Test extends AbstractJDKListTest<Integer> {

	ListAllocationContext<Integer> contextEmptyList = new ListAllocationContextImpl<>(CollectionTypeEnum.ARRAY);
	
	ListAllocationContext<Integer> contextCopyList = new ListAllocationContextImpl<>(CollectionTypeEnum.ARRAY);
	
	@Override
	protected List<Integer> getNewList() {
		return contextEmptyList.createList();
	}

	@Override
	protected List<Integer> copyList(List<Integer> fullList2) {
		return contextCopyList.createList(fullList2);
	}

}
