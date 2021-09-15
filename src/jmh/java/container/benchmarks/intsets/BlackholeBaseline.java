package container.benchmarks.intsets;

import org.openjdk.jmh.annotations.Param;

import container.factories.BlackholeFact;

public class BlackholeBaseline extends AbstractIntSetBenchmark<Void> {
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

	@Override
	protected void forEachLoop() {
		// nothing even to consume
	}

	@Override
	protected void forLoop() {
		// nothing even to consume
	}

	@Override
	protected void iterate() {
		// nothing even to consume
	}
}