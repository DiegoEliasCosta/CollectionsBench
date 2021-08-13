package container.benchmarks.intsets;

import java.util.Iterator;

import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.IntSet;
import com.carrotsearch.hppc.cursors.IntCursor;
import com.carrotsearch.hppc.procedures.IntProcedure;

import container.factories.HPPCIntSetFact;

public class HPPCIntSet extends AbstractIntSetBenchmark<IntSet> {
	@Param
	public HPPCIntSetFact impl;

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
		set.removeAll(object);
	}

	@Override
	protected void forLoop() {
		for (IntCursor i : set) {
			bh.consume(i.value);
		}
	}

	@Override
	protected void iterate() {
		for (Iterator<IntCursor> it = set.iterator(); it.hasNext();) {
			bh.consume(it.next());
		}
	}

	@Override
	protected void forEachLoop() {
		set.forEach((IntProcedure) bh::consume);
	}
}
