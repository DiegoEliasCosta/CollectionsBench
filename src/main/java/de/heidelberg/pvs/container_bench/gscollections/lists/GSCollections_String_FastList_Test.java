package de.heidelberg.pvs.container_bench.gscollections.lists;

import java.util.List;

import com.gs.collections.impl.list.mutable.FastList;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;

public class GSCollections_String_FastList_Test extends AbstractJDKListTest<String> {

	@Override
	protected List<String> getNewList() {
		return new FastList<>();
	}

	@Override
	protected List<String> copyList(List<String> fullList2) {
		return new FastList<>(fullList2);
	}

}
