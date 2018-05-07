package de.heidelberg.pvs.container_bench.wordlist.sets;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.BlackholeFact;

public class Blackhole extends AbstractWordSetBenchmark<Void> {
	@Param
	public BlackholeFact impl;

	@Override
	protected Void makeSet() {
		return null;
	}

	@Override
	protected void add(String object) {
		bh.consume(object);
	}
	
	@Override
	protected boolean contains(String object) {
		return false;
	}

	@Override
	protected void remove(String object) {
		bh.consume(object);
	}
}
