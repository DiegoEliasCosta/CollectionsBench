package de.heidelberg.pvs.container_bench.fastutils.lists;

import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

public class FastUtils_String_ArrayList_Test extends AbstractJDKListTest<String> {

	@Override
	protected List<String> getNewList() {
		return new ObjectArrayList<>();
	}

	@Override
	protected List<String> copyList(List<String> fullList2) {
		return new ObjectArrayList<>(fullList2);
	}

}
