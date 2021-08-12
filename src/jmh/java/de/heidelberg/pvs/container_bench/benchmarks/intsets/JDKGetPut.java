package de.heidelberg.pvs.container_bench.benchmarks.intsets;

import java.util.Set;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.JDKIntSetFact;

public class JDKGetPut extends AbstractIntSetBenchmark<Set<Integer>> {
	@Param
	public JDKIntSetFact impl;

	@Override
	protected Set<Integer> makeSet() {
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
