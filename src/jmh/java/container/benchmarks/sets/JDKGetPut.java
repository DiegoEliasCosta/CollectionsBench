package container.benchmarks.sets;

import java.util.Iterator;
import java.util.Set;

import org.openjdk.jmh.annotations.Param;

import container.factories.JDKSetFact;

public class JDKGetPut extends AbstractWordSetBenchmark<Set<String>> {
	@Param
	public JDKSetFact impl;

	@Override
	@SuppressWarnings("unchecked")
	protected Set<String> makeSet() {
		// FIXME: Find a better way to avoid this cast
		return (Set<String>) impl.maker.get();
	}

	@Override
	protected void add(String object) {
		set.add(object);
	}

	@Override
	protected boolean contains(String object) {
		return set.contains(object);
	}

	@Override
	protected void remove(String object) {
		set.remove(object);
	}

	@Override
	protected void forLoop() {
		for (String word : set) {
			bh.consume(word);
		}
	}

	@Override
	protected void iterate() {
		for (Iterator<String> iter = set.iterator(); iter.hasNext();) {
			bh.consume(iter.next());
		}
	}

	@Override
	protected void forEachLoop() {
		set.forEach(bh::consume);
	}
}
