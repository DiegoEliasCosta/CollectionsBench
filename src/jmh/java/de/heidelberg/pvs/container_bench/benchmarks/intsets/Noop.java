package de.heidelberg.pvs.container_bench.benchmarks.intsets;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.BlackholeFact;

/**
 * Noop class - this is supposed to be as fast as blackhole.
 *
 * Otherwise, we may need to reenable blackholing in other benchmarks.
 */
public class Noop extends AbstractIntSetBenchmark<Void> {
	@Param
	public BlackholeFact impl;

	@Override
	protected Void makeSet() {
		return null;
	}

	@Override
	protected void add(int object) {
		return; // Empty, not even blackhole
	}

	@Override
	protected boolean contains(int object) {
		return false; // Empty, not even blackhole
	}

	@Override
	protected void remove(int object) {
		return; // Empty, not even blackhole
	}
}
