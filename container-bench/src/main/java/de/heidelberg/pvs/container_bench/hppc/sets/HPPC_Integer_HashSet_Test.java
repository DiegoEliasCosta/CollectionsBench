package de.heidelberg.pvs.container_bench.hppc.sets;

import org.openjdk.jmh.annotations.Benchmark;

import com.carrotsearch.hppc.ObjectHashSet;
import com.carrotsearch.hppc.cursors.ObjectCursor;

import de.heidelberg.pvs.container_bench.abstracts.AbstractSetTest;
import de.heidelberg.pvs.container_bench.random.IntegerRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class HPPC_Integer_HashSet_Test extends AbstractSetTest<Integer> {

	ObjectHashSet<Integer> fullSet;
	Integer[] values;
	
	@Override
	public void testSetup() {
		fullSet = new ObjectHashSet<>();
		values = this.generator.generateArray(size);
		for(int i = 0; i < size; i++) {
			fullSet.add(values[i]);
		}
		
	}

	@Override
	protected RandomGenerator<Integer> instantiateRandomGenerator() {
		return new IntegerRandomGenerator();
	}

	@Override
	@Benchmark
	public void getAll() {
		for(ObjectCursor<Integer> element : fullSet) {
			blackhole.consume(element);
		}
	}

	@Override
	@Benchmark
	public void removeElement() {
		int index = generator.generateIndex(size);
		blackhole.consume(this.fullSet.remove(values[index]));
	}

	@Override
	@Benchmark
	public void containsElement() {
		Integer index = generator.generateIndex(size);
		blackhole.consume(fullSet.contains(values[index]));
		
	}

	@Override
	@Benchmark
	public void addAll() {
		ObjectHashSet<Integer> newSet = new ObjectHashSet<>();
		for(int i = 0; i < size; i++) {
			blackhole.consume(newSet.add(values[i]));
		}
		
	}

	@Override
	@Benchmark
	public void copySet() {
		ObjectHashSet<Integer> newSet = new ObjectHashSet<>(fullSet);
		blackhole.consume(newSet);
		
	}

	

}
