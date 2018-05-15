package de.heidelberg.pvs.container_bench.benchmarks.intsets;

import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.IntSet;

import de.heidelberg.pvs.container_bench.factories.HPPCIntSetFact;

public class HPPCIntSet extends AbstractIntSetBenchmark<IntSet> {
	@Param
	public HPPCIntSetFact impl;

	@Override
	protected IntSet makeSet() {
		return impl.maker.get();
	}

	@Override
	protected void add(int object) {
		set.add(object);
	}

	@Override
	protected boolean contains(int object) {
		return set.contains(object);
	}

	@Override
	protected void remove(int object) {
		set.removeAll(object);
	}
}
