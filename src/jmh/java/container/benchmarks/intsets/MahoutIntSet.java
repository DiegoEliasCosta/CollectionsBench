package container.benchmarks.intsets;

import org.apache.mahout.math.set.OpenIntHashSet;
import org.openjdk.jmh.annotations.Param;

import container.factories.MahoutIntSetFact;

public class MahoutIntSet extends AbstractIntSetBenchmark<OpenIntHashSet> {
	@Param
	public MahoutIntSetFact impl;

	@Override
	protected OpenIntHashSet makeSet() {
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
		throw new UnsupportedOperationException("Mahout does not allow standard for loops.");
	}

	@Override
	protected void iterate() {
		throw new UnsupportedOperationException("Mahout does not allow optimized for loops.");
	}

	@Override
	protected void forEachLoop() {
		set.forEachKey(x -> {
			bh.consume(x);
			return true;
		});
	}
}
