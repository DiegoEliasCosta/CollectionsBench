package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.sets;

import org.eclipse.collections.api.block.procedure.primitive.IntProcedure;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.EclipseIntSetFact;

public class EclipseIntSetBench extends AbstractIntSetBench {

	@Param
	EclipseIntSetFact impl;
	
	MutableIntSet fullSet;
	
	@Override
	public void testSetup() {
		fullSet = impl.maker.get();
		for (int i = 0; i < values.length; i++) {
			fullSet.add(values[i]);
		}
	}
	
	@Override
	protected void populateBench() {
		MutableIntSet newSet = impl.maker.get();
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
		MutableIntSet newSet = impl.maker.get();
		newSet.addAll(fullSet);
		blackhole.consume(newSet);
	}

	@Override
	protected void iterateBench() {
		fullSet.forEach(new IntProcedure() {
			@Override
			public void value(int each) {
				blackhole.consume(each);
			}
		});
	}

}
