package de.heidelberg.pvs.container_bench.hppc.sets;

import org.openjdk.jmh.annotations.Benchmark;

import com.carrotsearch.hppc.ObjectHashSet;
import com.carrotsearch.hppc.cursors.ObjectCursor;

import de.heidelberg.pvs.container_bench.abstracts.AbstractSetTest;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class HPPC_Long_HashSet_Test extends AbstractSetTest<Long> {

	ObjectHashSet<Long> fullSet;
	Long[] values;
	
	@Override
	public void testSetup() {
		fullSet = new ObjectHashSet<>();
		values = this.generator.generateArray(size);
		for(int i = 0; i < size; i++) {
			fullSet.add(values[i]);
		}
		
	}

	@Override
	protected RandomGenerator<Long> instantiateRandomGenerator() {
		return new LongRandomGenerator();
	}

	@Override
	public void getAll() {
		for(ObjectCursor<Long> element : fullSet) {
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
		ObjectHashSet<Long> newSet = new ObjectHashSet<>();
		for(int i = 0; i < size; i++) {
			blackhole.consume(newSet.add(values[i]));
		}
		
	}

	@Override
	@Benchmark
	public void copySet() {
		ObjectHashSet<Long> newSet = new ObjectHashSet<>(fullSet);
		blackhole.consume(newSet);
		
	}

}
