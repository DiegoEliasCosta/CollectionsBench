package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.lists;

import gnu.trove.iterator.TIntIterator;
import gnu.trove.list.array.TIntArrayList;

public class TroveIntListIterator extends AbstractIntListBenchmark {
	TIntArrayList fullList;

	@Override
	public void testSetup() {
		fullList = new TIntArrayList();
		for (int i = 0; i < values.length && failIfInterrupted(); i++) {
			fullList.add(values[i]);
		}
	}

	@Override
	protected void populateBench() {
		TIntArrayList newList = new TIntArrayList();
		for (int i = 0; i < values.length && failIfInterrupted(); i++) {
			newList.add(values[i]);
		}
		blackhole.consume(newList);

	}

	@Override
	protected void containsBench() {
		int index = generator.generateIndex(seed);
		blackhole.consume(fullList.contains(values[index]));
	}

	@Override
	protected void copyBench() {
		TIntArrayList newList = new TIntArrayList(fullList);
		blackhole.consume(newList);
	}

	@Override
	protected void iterateBench() {
		for (TIntIterator iter = fullList.iterator(); iter.hasNext() && failIfInterrupted();) {
			blackhole.consume(iter.next());
		}
	}
}
