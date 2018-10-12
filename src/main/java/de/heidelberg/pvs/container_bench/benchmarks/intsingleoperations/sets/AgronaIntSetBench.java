package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.sets;

import org.agrona.collections.IntHashSet;
import org.agrona.collections.IntHashSet.IntIterator;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.AgronaIntSetFact;

public class AgronaIntSetBench extends AbstractIntSetBench {

	@Param
	public AgronaIntSetFact impl;

	IntHashSet fullSet;

	@Override
	public void testSetup() {
		fullSet = impl.maker.get();
		for (int i = 0; i < values.length; i++) {
			fullSet.add(values[i]);
		}
	}

	@Override
	protected void populateBench() {
		IntHashSet newSet = impl.maker.get();
		for (int i = 0; i < values.length; i++) {
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
		IntHashSet newSet = impl.maker.get();
		newSet.addAll(fullSet);
		blackhole.consume(newSet);
	}

	@Override
	protected void iterateBench() {
		// No for each without unboxing
		IntIterator iterator = fullSet.iterator();
		while (iterator.hasNext()) {
			blackhole.consume(iterator.nextValue());
		}
	}
}
