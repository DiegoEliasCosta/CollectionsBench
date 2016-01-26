package de.heidelberg.pvs.container_bench.fastutils.lists;

import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

public class FastUtils_String_ArrayList_Test extends AbstractJDKListTest<String> {

	@Override
	protected List<String> getNewList(int size) {
		return new ObjectArrayList<>();
	}

	@Override
	protected List<String> copyList(List<String> fullList2) {
		return new ObjectArrayList<>(fullList2);
	}

	@Override
	protected RandomGenerator<String> instantiateRandomGenerator() {
		return new StringRandomGenerator();
	}

}
