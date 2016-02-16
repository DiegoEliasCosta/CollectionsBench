package de.heidelberg.pvs.container_bench.abstracts.guava;

import org.openjdk.jmh.annotations.Benchmark;

import com.google.common.collect.Multiset;

import de.heidelberg.pvs.container_bench.abstracts.AbstractSetTest;

public abstract class AbstractGuavaMultiSetTest<T> extends AbstractSetTest<T> {

	private T[] values;
	private T[] newValues;
	private Multiset<T> fullSet;
	
	protected abstract Multiset<T> getNewMultiSet();
	
	protected abstract Multiset<T> copyMultiSet(Multiset<T> original);
	
	@Override
	public void testSetup() {
		fullSet = this.getNewMultiSet();
		values = this.generator.generateArray(size);
		newValues = this.generator.generateArrayInRange(size, 2 * size);
		for (int i = 0; i < values.length; i++) {
			fullSet.add(values[i]);
		}
	}

	@Override
	@Benchmark
	public void getAll() {
		for(T element : fullSet) {
			blackhole.consume(element);
		}
	}

	@Override
	@Benchmark
	public void containsElement() {
		Integer index = this.generator.generateIndex(size);
		blackhole.consume(fullSet.contains(values[index]));
		
	}

	@Override
	@Benchmark
	public void addAll() {
		Multiset<T> newSet = this.getNewMultiSet();
		for(int i = 0; i < values.length; i++) {
			blackhole.consume(newSet.add(values[i]));
		}
	}
	
	@Override
	@Benchmark
	public void addAndRemoveElement() {
		Integer index = this.generator.generateIndex(size);
		blackhole.consume(this.fullSet.add(newValues[index]));
		blackhole.consume(this.fullSet.remove(newValues[index]));
	}

	@Override
	@Benchmark
	public void copySet() {
		Multiset<T> copiedSet = this.copyMultiSet(fullSet);
		blackhole.consume(copiedSet);
	}
	
	@Override
	@Benchmark
	public void getSize() {
		blackhole.consume(fullSet.size());
	}


}
