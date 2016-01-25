package de.heidelberg.pvs.container_bench.fastutils.lists;

import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import it.unimi.dsi.fastutil.ints.IntArrayList;

public class FastUtils_Integer_ArrayList_Test extends AbstractJDKListTest<Integer> {

	@Override
	protected List<Integer> getNewList(int size) {
		return new IntArrayList();
	}

	@Override
	protected List<Integer> copyList(List<Integer> fullList2) {
		return new IntArrayList(fullList2);
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomGenerator() {
		return new IntegerRandomGenerator();
	}

}
