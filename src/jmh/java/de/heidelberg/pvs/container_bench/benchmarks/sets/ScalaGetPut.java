package de.heidelberg.pvs.container_bench.benchmarks.sets;

import scala.collection.mutable.Set;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.ScalaSetFact;

public class ScalaGetPut extends AbstractWordSetBenchmark<Set<String>> {
	@Param
	public ScalaSetFact impl;

	@SuppressWarnings("unchecked")
	@Override
	protected Set<String> makeSet() {
		return (Set<String>) impl.maker.get();
	}

	@Override
	protected void add(String object) {
		set.add(object);
	}

	@Override
	protected boolean contains(String object) {
		return ((scala.collection.Set<String>) set).contains(object);
	}

	@Override
	protected void remove(String object) {
		set.remove(object);
	}
}
