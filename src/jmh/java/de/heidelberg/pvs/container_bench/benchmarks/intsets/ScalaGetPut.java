package de.heidelberg.pvs.container_bench.benchmarks.intsets;

import scala.collection.mutable.Set;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.ScalaSetFact;

public class ScalaGetPut extends AbstractIntSetBenchmark<Set<Integer>> {
	@Param
	public ScalaSetFact impl;

	@SuppressWarnings("unchecked")
	@Override
	protected Set<Integer> makeSet() {
		return (Set<Integer>) impl.maker.get();
	}

	@Override
	protected void add(int object) {
		set.add(object);
	}

	@Override
	protected boolean contains(int object) {
		return ((scala.collection.Set<Integer>) set).contains(object);
	}

	@Override
	protected void remove(int object) {
		set.remove(object);
	}
}
