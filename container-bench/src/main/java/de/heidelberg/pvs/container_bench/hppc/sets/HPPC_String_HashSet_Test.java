package de.heidelberg.pvs.container_bench.hppc.sets;

import com.carrotsearch.hppc.ObjectHashSet;

import de.heidelberg.pvs.container_bench.abstracts.hppc.AbstractHPPCSetTest;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;

public class HPPC_String_HashSet_Test extends AbstractHPPCSetTest<String> {

	@Override
	protected ObjectHashSet<String> getNewSet(int size) {
		return new ObjectHashSet<>();
	}

	@Override
	protected ObjectHashSet<String> copySet(ObjectHashSet<String> original) {
		return new ObjectHashSet<>(original);
	}

	@Override
	protected RandomGenerator<String> instantiateRandomGenerator() {
		return new StringRandomGenerator();
	}


	

}
