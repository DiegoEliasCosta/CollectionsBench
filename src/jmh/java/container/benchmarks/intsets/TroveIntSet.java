package container.benchmarks.intsets;

import org.openjdk.jmh.annotations.Param;

import container.factories.TroveIntSetFact;
import gnu.trove.set.TIntSet;

public class TroveIntSet extends AbstractIntSetBenchmark<TIntSet> {
	@Param
	public TroveIntSetFact impl;

	@Override
	protected TIntSet makeSet() {
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
}
