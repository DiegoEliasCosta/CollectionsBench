package container.benchmarks.sets;

import scala.Unit;
import scala.collection.Iterator;
import scala.collection.mutable.Set;

import org.openjdk.jmh.annotations.Param;

import container.factories.ScalaSetFact;

public class ScalaGetPut extends AbstractWordSetBenchmark<Set<String>> {
	@Param
	public ScalaSetFact impl;

	@SuppressWarnings("unchecked")
	@Override
	protected Set<String> makeSet() {
		return (Set<String>) impl.maker.get();
	}

	@Override
	protected void add(String object) {
		set.add(object);
	}

	@Override
	protected boolean contains(String object) {
		return ((scala.collection.Set<String>) set).contains(object);
	}

	@Override
	protected void remove(String object) {
		set.remove(object);
	}

	@Override
	protected void forLoop() {
		throw new UnsupportedOperationException("Scala does not have a standard for loop.");
	}

	@Override
	protected void iterate() {
		for (Iterator<String> iter = set.iterator(); iter.hasNext();) {
			bh.consume(iter.next());
		}
	}

	@Override
	protected void forEachLoop() {
		set.iterator().<Unit>foreach(x -> {
			bh.consume(x);
			return null;
		});
	}
}
