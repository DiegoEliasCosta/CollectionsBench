package de.heidelberg.pvs.container_bench.wordlist.intsets;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.BlackholeFact;

public class Blackhole extends AbstractIntSetBenchmark<Void> {
	@Param
	public BlackholeFact impl;

	@Override
	protected Void makeSet() {
		return null;
	}

	@Override
	protected void add(int object) {
		bh.consume(object);
	}
	
	@Override
	protected boolean contains(int object) {
		return false;
	}

	@Override
	protected void remove(int object) {
		bh.consume(object);
	}
}