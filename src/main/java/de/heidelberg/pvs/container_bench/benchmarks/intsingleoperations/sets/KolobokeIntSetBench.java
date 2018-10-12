package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.sets;

import java.util.function.IntConsumer;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.KolobokeIntSetFact;
import com.koloboke.collect.set.IntSet;

public class KolobokeIntSetBench extends AbstractIntSetBench {

	@Param
	KolobokeIntSetFact impl;
	
	IntSet fullSet;
	
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
		IntSet newSet = impl.maker.get();
		newSet.addAll(fullSet);
		blackhole.consume(newSet);
	}

	@Override
	protected void iterateBench() {
		fullSet.forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				blackhole.consume(value);
			}
		});
		
	}
	
}
