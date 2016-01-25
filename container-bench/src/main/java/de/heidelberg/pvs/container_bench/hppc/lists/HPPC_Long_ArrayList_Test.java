package de.heidelberg.pvs.container_bench.hppc.lists;

import org.openjdk.jmh.annotations.Benchmark;

import com.carrotsearch.hppc.LongArrayList;
import com.carrotsearch.hppc.cursors.LongCursor;

import de.heidelberg.pvs.container_bench.abstracts.AbstractListTest;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class HPPC_Long_ArrayList_Test extends AbstractListTest<Long> {

	LongArrayList fullList;
	Long[] values;
	
	@Override
	public void testSetup() {
		fullList = new LongArrayList();
		values = this.generator.generateArray(size);
		for(int i = 0; i < size; i++) {
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
		for(LongCursor element : fullList) {
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
		LongArrayList newList = new LongArrayList();
		for(int i = 0; i < size; i++) {
			newList.add(values[i]);
		}		
	}

	@Override
	@Benchmark
	public void copyList() {
		LongArrayList newList = new LongArrayList();
		blackhole.consume(newList);
	}

}
