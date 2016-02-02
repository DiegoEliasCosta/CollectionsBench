package de.heidelberg.pvs.container_bench.hppc.lists;

import com.carrotsearch.hppc.ObjectArrayList;

import de.heidelberg.pvs.container_bench.abstracts.hppc.AbstractHPPCListTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class HPPC_Integer_ArrayList_Test extends AbstractHPPCListTest<Integer> {

	@Override
	protected ObjectArrayList<Integer> getNewList(int size) {
		return new ObjectArrayList<>();
	}

	@Override
	protected ObjectArrayList<Integer> copyList(ObjectArrayList<Integer> original) {
		return new ObjectArrayList<>(original);
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomGenerator() {
		return new IntegerRandomGenerator();
	}


}
