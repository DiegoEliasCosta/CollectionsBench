package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.lists;

import java.util.function.IntConsumer;

import it.unimi.dsi.fastutil.ints.IntArrayList;

public class FastutilIntListBench extends AbstractIntListBench {

	
	
	IntArrayList fullList;
	
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
		IntArrayList newlist = new IntArrayList(fullList);
		blackhole.consume(newlist);
	}

	@Override
	protected void iterateBench() {
		fullList.forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				blackhole.consume(value);
			}
		});
	}


}
