package de.heidelberg.pvs.container_bench.abstracts.hppc;

import java.util.Set;

import org.openjdk.jmh.annotations.Benchmark;

import com.carrotsearch.hppc.ObjectHashSet;
import com.carrotsearch.hppc.cursors.ObjectCursor;

import de.heidelberg.pvs.container_bench.abstracts.AbstractSetTest;

/**
 * Abstract class for every test with JDK Sets implementation
 * @author Diego
 *
 * @param <T>
 * 		The held type of the {@link Set} implementation
 */
public abstract class AbstractHPPCSetTest<T> extends AbstractSetTest<T> {
	
	private ObjectHashSet<T> fullSet;
	private T[] values;
	private T[] newValues;
	private int newValuesSize;
	
	protected abstract ObjectHashSet<T> getNewSet(int size);
	protected abstract ObjectHashSet<T> copySet(ObjectHashSet<T> original);
	
	
	public void testSetup() {
		newValuesSize = 2 * size; // 50% of colision
		fullSet = this.getNewSet(size);
		values = generator.generateArray(size);
		newValues = generator.generateArray(2 * size);
		for(int i = 0; i < size; i++) {
			fullSet.add(values[i]);
		}
	}
	
	@Benchmark
	public void getAll() { 
		for(ObjectCursor<T> element : fullSet) {
			blackhole.consume(element);
		}
	}
	
	
	@Benchmark
	public void containsElement() {
		Integer index = generator.generateIndex(size);
		blackhole.consume(fullSet.contains(values[index]));
	}


	@Benchmark
	public void addAll() {
		ObjectHashSet<T> newSet = this.getNewSet(size);
		for(int i = 0; i < size; i++) {
			blackhole.consume(newSet.add(values[i]));
		}
	}
	
	@Benchmark
	public void addAndRemoveElement() {
		Integer index = this.generator.generateIndex(newValuesSize);
		blackhole.consume(this.fullSet.add(newValues[index]));
		blackhole.consume(this.fullSet.remove(newValues[index]));
	}

	@Benchmark
	public void copySet() {
		ObjectHashSet<T> newSet = this.copySet(fullSet);
		blackhole.consume(newSet);
	}
	
	@Override
	@Benchmark
	public void getSize() {
		blackhole.consume(fullSet.size());
	}
}