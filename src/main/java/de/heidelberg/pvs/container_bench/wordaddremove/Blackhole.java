package de.heidelberg.pvs.container_bench.wordaddremove;

import org.openjdk.jmh.annotations.Param;

public class Blackhole extends AbstractWordAddRemoveBenchmark<Void> {
	@Param({ "BLACKHOLE" })
	public String impl;

	@Override
	protected Void makeSet() {
		return null;
	}

	@Override
	protected int size(Void map) {
		return 0;
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
