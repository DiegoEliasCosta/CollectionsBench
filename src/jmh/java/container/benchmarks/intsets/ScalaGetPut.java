package container.benchmarks.intsets;

import org.openjdk.jmh.annotations.Param;

import container.factories.ScalaSetFact;
import scala.Unit;
import scala.collection.mutable.Set;

public class ScalaGetPut extends AbstractIntSetBenchmark<Set<Integer>> {
	@Param
	public ScalaSetFact impl;

	@SuppressWarnings("unchecked")
	@Override
	protected Set<Integer> makeSet() {
		return (Set<Integer>) impl.maker.get();
	}

	@Override
	protected void add(int object) {
		set.add(object);
	}

	@Override
	protected boolean contains(int object) {
		return ((scala.collection.Set<Integer>) set).contains(object);
	}

	@Override
	protected void remove(int object) {
		set.remove(object);
	}

	@Override
	protected void forLoop() {
		throw new UnsupportedOperationException("Scala does not have a standard for loop.");
	}

	@Override
	protected void iterate() {
		for (scala.collection.Iterator<Integer> it = set.iterator(); it.hasNext();) {
			bh.consume(it.next());
		}
	}

	@Override
	protected void forEachLoop() {
		set.iterator().foreach(x -> {
			bh.consume(x);
			return (Unit) null;
		});
	}
}
