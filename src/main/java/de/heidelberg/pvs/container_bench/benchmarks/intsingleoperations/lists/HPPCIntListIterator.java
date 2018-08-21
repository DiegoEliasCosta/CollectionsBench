package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.lists;

import com.carrotsearch.hppc.IntArrayList;
import com.carrotsearch.hppc.cursors.IntCursor;

public class HPPCIntListIterator extends AbstractIntListBenchmark {
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
		for (int i = 0; i < values.length && failIfInterrupted(); i++) {
			fullList.add(values[i]);
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
		IntArrayList newList = new IntArrayList(fullList);
		blackhole.consume(newList);
	}

	@Override
	protected void iterateBench() {
		for (IntCursor c : fullList) {
			failIfInterrupted();
			blackhole.consume(c.value);
		}
	}
}
