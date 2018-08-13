package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.lists;

import java.util.function.IntConsumer;

import org.agrona.collections.IntArrayList;
import org.openjdk.jmh.annotations.Param;


public class AgronaIntListBench extends AbstractIntListBench {

	IntArrayList fullList;
	
	@Param
	public AgronaIntListFact impl;
	
	public enum AgronaIntListFact {
		AGRONA_I_ARRAY
	}
	
	
	@Override
	public void testSetup() {
		fullList = new IntArrayList();
		for (int i = 0; i < values.length; i++) {
			fullList.add(values[i]);
		}
	}
	
	
	@Override
	protected void populateBench() {
		IntArrayList newList = new IntArrayList();
		for (int i = 0; i < size; i++) {
			newList.add(values[i]);
		}
		blackhole.consume(newList);
	}

	@Override
	protected void containsBench() {
		int index = generator.generateIndex(size);
		blackhole.consume(fullList.contains(values[index]));
	}

	@Override
	protected void copyBench() {
		// Agrora has no API for copying an array
		IntArrayList newlist = new IntArrayList(fullList.size(), -1);
		for (int i = 0; i < values.length; i++) {
			newlist.add(values[i]);
		}
		blackhole.consume(newlist);
	}

	@Override
	protected void iterateBench() {
		fullList.forEachOrderedInt(new IntConsumer() {
			@Override
			public void accept(int value) {
				blackhole.consume(value);
			}
		});
	}

	

}
