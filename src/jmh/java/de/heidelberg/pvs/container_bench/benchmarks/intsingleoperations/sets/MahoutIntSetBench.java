package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.sets;

import org.apache.mahout.math.function.IntProcedure;
import org.apache.mahout.math.set.OpenIntHashSet;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.MahoutIntSetFact;

public class MahoutIntSetBench extends AbstractIntSetBench {

	@Param
	MahoutIntSetFact impl;
	
	OpenIntHashSet fullSet;
	
	@Override
	public void testSetup() {
		fullSet = impl.maker.get();
		for (int i = 0; i < values.length; i++) {
			fullSet.add(values[i]);
		}
	}
	
	@Override
	protected void populateBench() {
		OpenIntHashSet newSet = impl.maker.get();
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
		OpenIntHashSet newSet = impl.maker.get();
		newSet.ensureCapacity(size);
		// Mahout does not provide an API for copying 
		fullSet.forEachKey(new IntProcedure() {
			@Override
			public boolean apply(int element) {
				newSet.add(element);
				return true;
			}
		});
		blackhole.consume(newSet);
	}

	@Override
	protected void iterateBench() {
		fullSet.forEachKey(new IntProcedure() {
			@Override
			public boolean apply(int element) {
				blackhole.consume(element);
				return true;
			}
		});
		
	}

}
