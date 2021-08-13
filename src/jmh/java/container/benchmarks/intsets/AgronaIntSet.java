package container.benchmarks.intsets;

import org.agrona.collections.IntHashSet;
import org.agrona.collections.IntHashSet.IntIterator;
import org.openjdk.jmh.annotations.Param;

import container.factories.AgronaIntSetFact;

public class AgronaIntSet extends AbstractIntSetBenchmark<IntHashSet> {
	@Param
	public AgronaIntSetFact impl;

	@Override
	protected IntHashSet makeSet() {
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
		for (IntIterator it = set.iterator(); it.hasNext();) {
			bh.consume(it.nextValue());
		}
	}

	@Override
	protected void forEachLoop() {
		set.forEach(bh::consume);
	}
}
