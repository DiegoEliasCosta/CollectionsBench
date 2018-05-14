package de.heidelberg.pvs.container_bench.abstracts.guava;

import org.openjdk.jmh.annotations.Benchmark;

import com.google.common.collect.Multiset;

import de.heidelberg.pvs.container_bench.abstracts.AbstractSetBench;

public abstract class AbstractGuavaMultiSetBench<T> extends AbstractSetBench<T> {

	private T[] values;
	private T[] newValues;
	private Multiset<T> fullSet;
	private int newSize;
	
	protected abstract Multiset<T> getNewMultiSet();
	
	protected abstract Multiset<T> copyMultiSet(Multiset<T> original);
	
	@Override
	public void testSetup() {
		
		newSize = 2 * size; // 50% of collision
		
		fullSet = this.getNewMultiSet();
		values = this.generator.generateArray(size);
		newValues = this.generator.generateArrayFromPool(size, newSize);
		for (int i = 0; i < values.length; i++) {
			fullSet.add(values[i]);
		}
	}

	@Override
	@Benchmark
	public void iterate() {
		for(T element : fullSet) {
			blackhole.consume(element);
		}
	}

	@Override
	@Benchmark
	public void containsElement() {
		int index = this.generator.generateIndex(size);
		blackhole.consume(fullSet.contains(values[index]));
		
	}

	@Override
	@Benchmark
	public void populate() {
		Multiset<T> newSet = this.getNewMultiSet();
		for(int i = 0; i < values.length; i++) {
			newSet.add(values[i]);
		}
		blackhole.consume(newSet);
	}
	
	@Override
	@Benchmark
	public void addElement() {
		int index = this.generator.generateIndex(newSize);
		blackhole.consume(this.fullSet.add(newValues[index]));
		blackhole.consume(this.fullSet.remove(newValues[index]));
	}

	@Override
	@Benchmark
	public void copy() {
		Multiset<T> copiedSet = this.copyMultiSet(fullSet);
		blackhole.consume(copiedSet);
	}
	
	@Override
	@Benchmark
	public void removeElement() {
		int index = this.generator.generateIndex(size);
		blackhole.consume(this.fullSet.remove(values[index]));
		blackhole.consume(this.fullSet.add(values[index])); // Keeping the steady-state
	}

	@Override
	protected Object getFullCollection() {
		return fullSet;
	}

}
