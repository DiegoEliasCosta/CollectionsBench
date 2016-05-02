package de.heidelberg.pvs.container_bench.fastutils.lists_p;

import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import it.unimi.dsi.fastutil.ints.IntArrayList;

public class FastUtils_Integer_PArrayList_Test extends AbstractJDKListTest<Integer> {

	@Override
	protected List<Integer> getNewList(int size) {
		return new IntArrayList();
	}

	@Override
	protected List<Integer> copyList(List<Integer> fullList2) {
		return new IntArrayList(fullList2);
	}

}
