package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.sets;

import java.util.function.Consumer;

import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.IntHashSet;
import com.carrotsearch.hppc.IntSet;
import com.carrotsearch.hppc.cursors.IntCursor;

import de.heidelberg.pvs.container_bench.factories.HPPCIntSetFact;

public class HPPCIntSetBench extends AbstractIntSetBench {
	
	@Param
	HPPCIntSetFact impl;
	
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
		
		IntSet newSet = impl.maker.get();
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
		fullSet.forEach(new Consumer<IntCursor>() {
			@Override
			public void accept(IntCursor t) {
				blackhole.consume(t.value);
			}
		});
	}
}
