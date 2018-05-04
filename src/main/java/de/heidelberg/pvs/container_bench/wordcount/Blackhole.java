package de.heidelberg.pvs.container_bench.wordcount;

import org.openjdk.jmh.annotations.Param;

public class Blackhole extends AbstractWordcountBenchmark<Void> {
	@Param({ "BLACKHOLE" })
	public String impl;

	@Override
	protected Void makeMap() {
		return null;
	}

	@Override
	protected int size(Void map) {
		return 0;
	}

	@Override
	protected void count(Void map, String object) {
		bh.consume(object.hashCode());
	}
}
