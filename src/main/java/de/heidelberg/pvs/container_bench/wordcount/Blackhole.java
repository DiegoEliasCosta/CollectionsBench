package de.heidelberg.pvs.container_bench.wordcount;

import org.openjdk.jmh.annotations.Param;

public class Blackhole extends AbstractWordcountBenchmark<Object> {
	@Param({ "BLACKHOLE" })
	public String impl;

	@Override
	protected Object makeMap() {
		return null;
	}

	@Override
	protected int size(Object map) {
		return 0;
	}

	@Override
	protected void count(Object map, Object object) {
		bh.consume(object.hashCode());
	}
}
