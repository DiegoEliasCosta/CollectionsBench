package container.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import container.factories.BlackholeFact;

public class Blackhole extends AbstractWordcountBenchmark<Void> {
	@Param
	public BlackholeFact impl;

	@Override
	protected Void makeMap() {
		return null;
	}

	@Override
	protected void count(Void map, String object) {
		bh.consume(object);
	}

	@Override
	protected long size(Void map) {
		return 0;
	}
}
