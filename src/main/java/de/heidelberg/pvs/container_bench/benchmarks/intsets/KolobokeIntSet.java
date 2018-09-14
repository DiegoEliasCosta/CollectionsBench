package de.heidelberg.pvs.container_bench.benchmarks.intsets;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.KolobokeIntSetFact;
import com.koloboke.collect.set.IntSet;

public class KolobokeIntSet extends AbstractIntSetBenchmark<IntSet> {
	@Param
	public KolobokeIntSetFact impl;

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
		set.removeInt(object);
	}
}
