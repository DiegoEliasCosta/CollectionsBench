package de.heidelberg.pvs.container_bench.benchmarks.intsets;

import org.apache.mahout.math.set.OpenIntHashSet;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.MahoutIntSetFact;

public class MahoutIntSet extends AbstractIntSetBenchmark<OpenIntHashSet> {
	@Param
	public MahoutIntSetFact impl;

	@Override
	protected OpenIntHashSet makeSet() {
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
