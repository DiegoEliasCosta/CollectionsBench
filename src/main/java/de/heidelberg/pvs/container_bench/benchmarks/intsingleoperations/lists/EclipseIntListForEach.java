package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.lists;

import org.eclipse.collections.api.block.procedure.primitive.IntProcedure;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;

public class EclipseIntListForEach extends AbstractIntListBenchmark {
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
		IntArrayList newList = IntArrayList.newList(fullList);
		blackhole.consume(newList);
	}

	@Override
	protected void iterateBench() {
		fullList.forEach(new IntProcedure() {
			private static final long serialVersionUID = 1L;

			@Override
			public void value(int each) {
				failIfInterrupted();
				blackhole.consume(each);
			}
		});
	}
}
