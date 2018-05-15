package de.heidelberg.pvs.container_bench.benchmarks.intsets;

import org.agrona.collections.IntHashSet;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.AgronaIntSetFact;

public class AgronaIntSet extends AbstractIntSetBenchmark<IntHashSet> {
	@Param
	public AgronaIntSetFact impl;

	@Override
	protected IntHashSet makeSet() {
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
