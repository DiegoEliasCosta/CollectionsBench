package de.heidelberg.pvs.container_bench.hppc.lists;

import com.carrotsearch.hppc.ObjectArrayList;

import de.heidelberg.pvs.container_bench.abstracts.hppc.AbstractHPPCListBench;

public class HPPC_Long_ArrayList_Test extends AbstractHPPCListBench<Long> {

	@Override
	protected ObjectArrayList<Long> getNewList(int size) {
		return new ObjectArrayList<>();
	}

	@Override
	protected ObjectArrayList<Long> copyList(ObjectArrayList<Long> original) {
		return new ObjectArrayList<>(original);
	}


}
