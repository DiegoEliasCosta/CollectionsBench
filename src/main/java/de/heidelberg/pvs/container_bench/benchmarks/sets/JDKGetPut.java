package de.heidelberg.pvs.container_bench.benchmarks.sets;

import java.util.Set;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.JDKSetFact;

public class JDKGetPut extends AbstractWordSetBenchmark<Set<String>> {
	@Param
	public JDKSetFact impl;

	@Override
	@SuppressWarnings("unchecked")
	protected Set<String> makeSet() {
		// FIXME: Find a better way to avoid this cast 
		return (Set<String>) impl.maker.get();
	}

	@Override
	protected void add(String object) {
		set.add(object);
	}

	@Override
	protected boolean contains(String object) {
		return set.contains(object);
	}

	@Override
	protected void remove(String object) {
		set.remove(object);
	}
}
