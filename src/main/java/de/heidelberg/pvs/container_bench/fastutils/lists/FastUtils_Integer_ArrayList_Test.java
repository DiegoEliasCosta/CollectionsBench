package de.heidelberg.pvs.container_bench.fastutils.lists;

import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

public class FastUtils_Integer_ArrayList_Test extends AbstractJDKListTest<Integer> {

	@Override
	protected List<Integer> getNewList(int size) {
		return new ObjectArrayList<>();
	}

	@Override
	protected List<Integer> copyList(List<Integer> fullList2) {
		return new ObjectArrayList<>(fullList2);
	}

}
