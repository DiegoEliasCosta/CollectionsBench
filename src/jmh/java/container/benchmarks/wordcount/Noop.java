package container.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import container.factories.BlackholeFact;

/**
 * Noop class - this is supposed to be as fast as blackhole.
 *
 * Otherwise, we may need to reenable blackholing in other benchmarks.
 */
public class Noop extends AbstractWordcountBenchmark<Void> {
	@Param
	public BlackholeFact impl;

	@Override
	protected Void makeMap() {
		return null;
	}

	@Override
	protected void count(Void map, String object) {
		// Empty, not even blackhole
	}
	
	@Override
	protected long size(Void map) {
		return 0;
	}
}
