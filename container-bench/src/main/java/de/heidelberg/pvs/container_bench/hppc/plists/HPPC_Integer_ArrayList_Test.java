package de.heidelberg.pvs.container_bench.hppc.plists;

import org.openjdk.jmh.annotations.Benchmark;

import com.carrotsearch.hppc.IntArrayList;
import com.carrotsearch.hppc.cursors.IntCursor;

import de.heidelberg.pvs.container_bench.abstracts.AbstractListTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class HPPC_Integer_ArrayList_Test extends AbstractListTest<Integer> {

	IntArrayList fullList;
	Integer[] values;
	
	@Override
	public void testSetup() {
		fullList = new IntArrayList();
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
		for(IntCursor element : fullList) {
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
		IntArrayList newList = new IntArrayList();
		for(int i = 0; i < size; i++) {
			newList.add(values[i]);
		}		
	}

	@Override
	@Benchmark
	public void copyList() {
		IntArrayList newList = new IntArrayList(fullList);
		blackhole.consume(newList);
	}

}
