package de.heidelberg.pvs.container_bench.hppc.sets;

import com.carrotsearch.hppc.ObjectHashSet;

import de.heidelberg.pvs.container_bench.abstracts.hppc.AbstractHPPCSetBench;

public class HPPC_Integer_HashSet_Test extends AbstractHPPCSetBench<Integer> {

	@Override
	protected ObjectHashSet<Integer> getNewSet(int size) {
		return new ObjectHashSet<>();
	}

	@Override
	protected ObjectHashSet<Integer> copySet(ObjectHashSet<Integer> original) {
		return new ObjectHashSet<>(original);
	}

}
