package container.benchmarks.intsets;

import java.util.Iterator;
import java.util.Set;

import org.openjdk.jmh.annotations.Param;

import container.factories.JDKIntSetFact;

public class JDKGetPut extends AbstractIntSetBenchmark<Set<Integer>> {
	@Param
	public JDKIntSetFact impl;

	@Override
	protected Set<Integer> makeSet() {
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
		for (Iterator<Integer> it = set.iterator(); it.hasNext();) {
			bh.consume(it.next());
		}
	}

	@Override
	protected void forEachLoop() {
		set.forEach(bh::consume);
	}
}
