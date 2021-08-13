package container.benchmarks.intsets;

import java.util.function.IntConsumer;

import org.openjdk.jmh.annotations.Param;

import container.factories.KolobokeIntSetFact;
import net.openhft.koloboke.collect.IntCursor;
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

	@Override
	protected void forLoop() {
		for (Integer i : set) {
			bh.consume(i);
		}
	}

	@Override
	protected void iterate() {
		for (IntCursor it = set.cursor(); it.moveNext();) {
			bh.consume(it.elem());
		}
	}

	@Override
	protected void forEachLoop() {
		set.forEach((IntConsumer) bh::consume);
	}
}
