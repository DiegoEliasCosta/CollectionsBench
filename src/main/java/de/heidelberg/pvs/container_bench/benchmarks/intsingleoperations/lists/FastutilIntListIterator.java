package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.lists;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntListIterator;

public class FastutilIntListIterator extends AbstractIntListBenchmark {
	IntArrayList fullList;

	@Override
	public void testSetup() {
		fullList = new IntArrayList();
		for (int i = 0; i < values.length && failIfInterrupted(); i++) {
			fullList.add(values[i]);
		}
	}

	@Override
	protected void populateBench() {
		IntArrayList newList = new IntArrayList();
		for (int i = 0; i < size && failIfInterrupted(); i++) {
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
		for (IntListIterator iter = fullList.iterator(); iter.hasNext() && failIfInterrupted();) {
			blackhole.consume(iter.nextInt());
		}
	}
}
