package container.benchmarks.sets;

import org.openjdk.jmh.annotations.Param;

import container.factories.BlackholeFact;

/**
 * Noop class - this is supposed to be as fast as blackhole.
 *
 * Otherwise, we may need to reenable blackholing in other benchmarks.
 */
public class Noop extends AbstractWordSetBenchmark<Void> {
	@Param
	public BlackholeFact impl;

	@Override
	protected Void makeSet() {
		return null;
	}

	@Override
	protected void add(String object) {
		// Empty, not even blackhole
	}

	@Override
	protected boolean contains(String object) {
		return false;
	}

	@Override
	protected void remove(String object) {
		// Empty, not even blackhole
	}

	@Override
	protected void forLoop() {
		// nothing even to consume
	}

	@Override
	protected void iterate() {
		// nothing even to consume
	}

	@Override
	protected void forEachLoop() {
		// nothing even to consume
	}
}
