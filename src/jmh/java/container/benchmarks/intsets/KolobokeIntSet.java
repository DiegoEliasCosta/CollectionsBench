package container.benchmarks.intsets;

import org.openjdk.jmh.annotations.Param;

import container.factories.KolobokeIntSetFact;
import net.openhft.koloboke.collect.set.IntSet;

public class KolobokeIntSet extends AbstractIntSetBenchmark<IntSet> {
	@Param
	public KolobokeIntSetFact impl;

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
		set.removeInt(object);
	}
}
