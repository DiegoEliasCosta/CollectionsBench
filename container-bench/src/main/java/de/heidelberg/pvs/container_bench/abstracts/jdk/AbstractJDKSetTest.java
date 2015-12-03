package de.heidelberg.pvs.container_bench.abstracts.jdk;

import java.util.Set;

import org.openjdk.jmh.annotations.Benchmark;

import de.heidelberg.pvs.container_bench.abstracts.AbstractSetTest;

/**
 * Abstract class for every test with JDK Sets implementation
 * @author Diego
 *
 * @param <T>
 * 		The held type of the {@link Set} implementation
 */
public abstract class AbstractJDKSetTest<T> extends AbstractSetTest<T> {
	
	private Set<T> fullSet;
	private T[] values;
	
	public void testSetup() {
		fullSet = this.getNewSet(size);
		values = generator.generateArray(size);
		for(int i = 0; i < size; i++) {
			fullSet.add(values[i]);
		}
	}
	
	protected abstract Set<T> getNewSet(int size);
	protected abstract Set<T> copySet(Set<T> fullSet2);
	
	@Benchmark
	public void getAll() { 
		for(T element : fullSet) {
			blackhole.consume(element);
		}
	}
	
	@Benchmark
	public void removeElement() {
		int index = generator.generateIndex(size);
		blackhole.consume(this.fullSet.remove(values[index]));
	}

	@Benchmark
	public void containsElement() {
		Integer index = generator.generateIndex(size);
		blackhole.consume(fullSet.contains(values[index]));
	}


	@Benchmark
	public void addAll() {
		Set<T> newSet = this.getNewSet(size);
		for(int i = 0; i < size; i++) {
			blackhole.consume(newSet.add(values[i]));
		}
	}

	@Benchmark
	public void copySet() {
		Set<T> newSet = this.copySet(fullSet);
		blackhole.consume(newSet);
	}
}