package de.heidelberg.pvs.container_bench.hppc.sets;

import com.carrotsearch.hppc.ObjectHashSet;

import de.heidelberg.pvs.container_bench.abstracts.hppc.AbstractHPPCSetBench;

public class HPPC_String_HashSet_Test extends AbstractHPPCSetBench<String> {

	@Override
	protected ObjectHashSet<String> getNewSet(int size) {
		return new ObjectHashSet<>();
	}

	@Override
	protected ObjectHashSet<String> copySet(ObjectHashSet<String> original) {
		return new ObjectHashSet<>(original);
	}


}
