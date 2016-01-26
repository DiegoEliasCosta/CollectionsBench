package de.heidelberg.pvs.container_bench.hppc.lists;

import org.openjdk.jmh.annotations.Benchmark;

import com.carrotsearch.hppc.ObjectArrayList;
import com.carrotsearch.hppc.cursors.ObjectCursor;

import de.heidelberg.pvs.container_bench.abstracts.AbstractListTest;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class HPPC_Long_ArrayList_Test extends AbstractListTest<Long> {

	ObjectArrayList<Long> fullList;
	Long[] values;

	@Override
	public void testSetup() {
		fullList = new ObjectArrayList<Long>();
		values = this.generator.generateArray(size);
		for (int i = 0; i < size; i++) {
			fullList.add(values[i]);
		}
	}

	@Override
	protected RandomGenerator<Long> instantiateRandomGenerator() {
		return new LongRandomGenerator();
	}

	@Override
	@Benchmark
	public void getAll() {
		for (ObjectCursor<Long> element : fullList) {
			blackhole.consume(element);
		}
	}

	@Override
	@Benchmark
	public void getElement() {
		Integer index = generator.generateIndex(size);
		blackhole.consume(fullList.get(index));
	}

	@Override
	@Benchmark
	public void removeElement() {
		Integer index = generator.generateIndex(size);
		blackhole.consume(fullList.remove(index));
	}

	@Override
	@Benchmark
	public void containsElement() {
		Integer index = generator.generateIndex(size);
		blackhole.consume(fullList.contains(values[index]));
	}

	@Override
	@Benchmark
	public void addAll() {
		ObjectArrayList<Long> newList = new ObjectArrayList<Long>();
		for (int i = 0; i < size; i++) {
			newList.add(values[i]);
		}
	}

	@Override
	@Benchmark
	public void copyList() {
		ObjectArrayList<Long> newList = new ObjectArrayList<Long>();
		blackhole.consume(newList);
	}

}
