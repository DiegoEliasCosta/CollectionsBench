package de.heidelberg.pvs.container_bench.wordcount;

import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.infra.Blackhole;

public class NoopBenchmark extends AbstractWordcountBenchmark<Object> {
	@Param({ "DISCARD" })
	public String impl;

	Blackhole bh;

	@Setup
	public void setupBlackhole(Blackhole b) {
		bh = b;
	}

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
		bh.consume(object);
	}
}
