package container.benchmarks.intsets;

import org.openjdk.jmh.annotations.Param;

import container.factories.FastutilIntSetFact;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntSet;

public class FastutilIntSet extends AbstractIntSetBenchmark<IntSet> {
	@Param
	public FastutilIntSetFact impl;

	@Override
	protected IntSet makeSet() {
		return impl.maker.get();
	}

	@Override
	protected void add(int object) {
		set.add(object);
	}

	@Override
	protected boolean contains(int object) {
		return set.contains(object);
	}

	@Override
	protected void remove(int object) {
		set.remove(object);
	}

	@Override
	protected void forLoop() {
		for (Integer i : set) {
			bh.consume(i);
		}
	}

	@Override
	protected void iterate() {
		for (IntIterator it = set.intIterator(); it.hasNext();) {
			bh.consume(it.nextInt());
		}
	}

	@Override
	protected void forEachLoop() {
		set.forEach(bh::consume);
	}
}
