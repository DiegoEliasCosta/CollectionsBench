package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.sets;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.TroveIntSetFact;
import gnu.trove.procedure.TIntProcedure;
import gnu.trove.set.TIntSet;

public class TroveIntSetBench extends AbstractIntSetBench {

	@Param
	TroveIntSetFact impl;
	
	TIntSet fullSet;

	@Override
	public void testSetup() {
		fullSet	= impl.maker.get();
		for (int i = 0; i < values.length; i++) {
			fullSet.add(values[i]);
		}
	}
	
	@Override
	protected void populateBench() {
		TIntSet newSet	= impl.maker.get();
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
		TIntSet newSet = impl.maker.get();
		newSet.addAll(fullSet);
		blackhole.consume(newSet);
	}

	@Override
	protected void iterateBench() {
		fullSet.forEach(new TIntProcedure() {
			@Override
			public boolean execute(int value) {
				blackhole.consume(value);
				return true; // keep executing TIntProcedure
			}
		});
	}
	
}
