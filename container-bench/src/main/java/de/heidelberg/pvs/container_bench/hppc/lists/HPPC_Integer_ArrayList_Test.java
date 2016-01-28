package de.heidelberg.pvs.container_bench.hppc.lists;

import org.openjdk.jmh.annotations.Benchmark;

import com.carrotsearch.hppc.ObjectArrayList;
import com.carrotsearch.hppc.cursors.ObjectCursor;

import de.heidelberg.pvs.container_bench.abstracts.AbstractListTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class HPPC_Integer_ArrayList_Test extends AbstractListTest<Integer> {

	ObjectArrayList<Integer> fullList;
	Integer[] values;
	
	@Override
	public void testSetup() {
		fullList = new ObjectArrayList<>();
		values = this.generator.generateArray(size);
		for(int i = 0; i < size; i++) {
			fullList.add(values[i]);
		}
		
	}

	
	@Override
	protected RandomGenerator<Integer> instantiateRandomGenerator() {
		return new IntegerRandomGenerator();
	}

	@Override
	@Benchmark
	public void getAll() {
		for(ObjectCursor<Integer> element : fullList) {
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
		ObjectArrayList<Integer> newList = new ObjectArrayList<>();
		for(int i = 0; i < size; i++) {
			newList.add(values[i]);
		}
		blackhole.consume(newList);
	}

	@Override
	@Benchmark
	public void copyList() {
		ObjectArrayList<Integer> newList = new ObjectArrayList<>(fullList);
		blackhole.consume(newList);
	}

}
