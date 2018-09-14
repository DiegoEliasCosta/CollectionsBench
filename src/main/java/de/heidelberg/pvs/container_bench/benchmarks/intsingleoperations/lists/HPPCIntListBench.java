package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.lists;

import java.util.function.Consumer;

import com.carrotsearch.hppc.IntArrayList;
import com.carrotsearch.hppc.cursors.IntCursor;
import com.carrotsearch.hppc.procedures.IntProcedure;

public class HPPCIntListBench extends AbstractIntListBench {
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
		for (int i = 0; i < values.length; i++) {
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
		fullList.forEach(new IntProcedure() {
			@Override
			public void apply(int value) {
				blackhole.consume(value);
			}
		});
	}

	// TODO: include this.
	protected void iterateOtherBench() {
		fullList.forEach(new Consumer<IntCursor>() {
			@Override
			public void accept(IntCursor t) {
				blackhole.consume(t.value);
			}
		});
	}
}
