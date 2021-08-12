package de.heidelberg.pvs.container_bench.benchmarks.intsets;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.FastutilIntSetFact;
import it.unimi.dsi.fastutil.ints.IntSet;

public class FastutilIntSet extends AbstractIntSetBenchmark<IntSet> {
	@Param
	public FastutilIntSetFact impl;

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
		set.remove(object);
	}
}
