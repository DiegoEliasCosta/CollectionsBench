package de.heidelberg.pvs.container_bench.fastutils.lists_p;

import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import it.unimi.dsi.fastutil.longs.LongArrayList;

public class FastUtils_Long_PArrayList_Test extends AbstractJDKListTest<Long> {

	@Override
	protected List<Long> getNewList(int size) {
		return new LongArrayList();
	}

	@Override
	protected List<Long> copyList(List<Long> fullList2) {
		return new LongArrayList(fullList2);
	}

}
