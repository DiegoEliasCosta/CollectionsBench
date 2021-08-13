package container.benchmarks.intsets;

import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.openjdk.jmh.annotations.Param;

import container.factories.EclipseIntSetFact;

public class EclipseIntSet extends AbstractIntSetBenchmark<MutableIntSet> {
	@Param
	public EclipseIntSetFact impl;

	@Override
	protected MutableIntSet makeSet() {
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
		throw new UnsupportedOperationException("Eclipse does not allow standard for loops.");
	}

	@Override
	protected void iterate() {
		for (IntIterator it = set.intIterator(); it.hasNext();) {
			bh.consume(it.next());
		}
	}

	@Override
	protected void forEachLoop() {
		set.forEach(bh::consume);
	}
}
