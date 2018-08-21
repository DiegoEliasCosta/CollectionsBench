package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.sets;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.TroveIntSetFact;
import gnu.trove.iterator.TIntIterator;
import gnu.trove.set.TIntSet;

public class TroveIntSetIterator extends AbstractIntSetBenchmark {
	@Param
	TroveIntSetFact impl;

	TIntSet fullSet;

	@Override
	public void testSetup() {
		fullSet = impl.maker.get();
		for (int i = 0; i < values.length && failIfInterrupted(); i++) {
			fullSet.add(values[i]);
		}
	}

	@Override
	protected void populateBench() {
		TIntSet newSet = impl.maker.get();
		for (int i = 0; i < values.length && failIfInterrupted(); i++) {
			newSet.add(values[i]);
		}
		blackhole.consume(newSet);
	}

	@Override
	protected void containsBench() {
		int index = generator.generateIndex(size);
		blackhole.consume(fullSet.contains(values[index]));
	}

	@Override
	protected void copyBench() {
		TIntSet newSet = impl.maker.get();
		newSet.addAll(fullSet);
		blackhole.consume(newSet);
	}

	@Override
	protected void iterateBench() {
		for (TIntIterator iter = fullSet.iterator(); iter.hasNext() && failIfInterrupted();) {
			blackhole.consume(iter.next());
		}
	}
}
