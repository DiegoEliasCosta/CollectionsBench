package container.benchmarks.intsingleoperations.lists;

import com.carrotsearch.hppc.IntArrayList;
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
}
