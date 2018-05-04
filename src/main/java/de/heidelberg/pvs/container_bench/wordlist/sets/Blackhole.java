package de.heidelberg.pvs.container_bench.wordlist.sets;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.BlackholeFact;

public class Blackhole extends AbstractWordAddRemoveBenchmark<Void> {
	@Param
	public BlackholeFact impl;

	@Override
	protected Void makeSet() {
		return null;
	}

	@Override
	protected void add(Void map, String object) {
		bh.consume(object.hashCode());
	}

	@Override
	protected void remove(Void map, String object) {
		bh.consume(object.hashCode());
	}
}
