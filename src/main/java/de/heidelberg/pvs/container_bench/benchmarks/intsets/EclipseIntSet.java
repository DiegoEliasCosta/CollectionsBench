package de.heidelberg.pvs.container_bench.benchmarks.intsets;

import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.EclipseIntSetFact;

public class EclipseIntSet extends AbstractIntSetBenchmark<MutableIntSet> {
	@Param
	public EclipseIntSetFact impl;

	@Override
	protected MutableIntSet makeSet() {
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
