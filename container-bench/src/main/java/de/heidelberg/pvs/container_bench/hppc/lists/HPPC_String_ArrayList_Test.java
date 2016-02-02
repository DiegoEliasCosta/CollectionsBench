package de.heidelberg.pvs.container_bench.hppc.lists;

import org.openjdk.jmh.annotations.Benchmark;

import com.carrotsearch.hppc.ObjectArrayList;
import com.carrotsearch.hppc.cursors.ObjectCursor;

import de.heidelberg.pvs.container_bench.abstracts.AbstractListTest;
import de.heidelberg.pvs.container_bench.abstracts.hppc.AbstractHPPCListTest;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;

public class HPPC_String_ArrayList_Test extends AbstractHPPCListTest<String> {

	@Override
	protected ObjectArrayList<String> getNewList(int size) {
		return new ObjectArrayList<>();
	}

	@Override
	protected ObjectArrayList<String> copyList(ObjectArrayList<String> original) {
		return new ObjectArrayList<>(original);
	}

	@Override
	protected RandomGenerator<String> instantiateRandomGenerator() {
		return new StringRandomGenerator();
	}


}
