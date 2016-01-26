package de.heidelberg.pvs.container_bench.hppc.lists;

import org.openjdk.jmh.annotations.Benchmark;

import com.carrotsearch.hppc.ObjectArrayList;
import com.carrotsearch.hppc.cursors.ObjectCursor;

import de.heidelberg.pvs.container_bench.abstracts.AbstractListTest;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;

public class HPPC_String_ArrayList_Test extends AbstractListTest<String> {

	ObjectArrayList<String> fullList;
	String[] values;

	@Override
	public void testSetup() {
		fullList = new ObjectArrayList<String>();
		values = this.generator.generateArray(size);
		for (int i = 0; i < size; i++) {
			fullList.add(values[i]);
		}
	}

	@Override
	protected RandomGenerator<String> instantiateRandomGenerator() {
		return new StringRandomGenerator();
	}

	@Override
	@Benchmark
	public void getAll() {
		for (ObjectCursor<String> element : fullList) {
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
		ObjectArrayList<String> newList = new ObjectArrayList<String>();
		for (int i = 0; i < size; i++) {
			newList.add(values[i]);
		}
	}

	@Override
	@Benchmark
	public void copyList() {
		ObjectArrayList<String> newList = new ObjectArrayList<String>();
		blackhole.consume(newList);
	}

}
