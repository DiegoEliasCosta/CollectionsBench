package de.heidelberg.pvs.container_bench.abstracts;

import java.util.ArrayList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.infra.Blackhole;

import de.heidelberg.pvs.container_bench.utils.RandomGenerator;


public abstract class AbstractJDKArrayListTest<T> extends AbstractListTest {
	
	private List<T> fullList = new ArrayList<T>();
	
	private T[] values;
	
	private static Blackhole blackhole;
	
	@Setup
	public void setup(final Blackhole bh) {
		blackhole = bh;
		fullList = new ArrayList<T>();
		values = this.generateRandomArray(seed, size);
		for(int i = 0; i < size; i++) {
			fullList.add(values[i]);
		}
	}
	
	protected abstract T[] generateRandomArray(int seed, int size);

	protected  abstract Integer generateRandomIndex(int seed, int size);
	
	@Benchmark
	public void getAll() {
		for(int i = 0; i < size; i++) {
			blackhole.consume(fullList.get(i));
		}
	}
	
	@Benchmark
	public void getAtIndex() {
		Integer index = this.generateRandomIndex(seed, size);
		blackhole.consume(fullList.get(index));
	}

	@Benchmark
	public void removeAtIndex() {
		Integer index = this.generateRandomIndex(seed, size);
		blackhole.consume(fullList.remove(index));
	}

	@Benchmark
	public void clear() {
		fullList.clear(); //void
	}

	@Benchmark
	public void contains() {
		Integer index = this.generateRandomIndex(seed, size);
		blackhole.consume(fullList.contains(values[index]));
	}

	@Benchmark
	public void instantiate() {
		List<T> newList = new ArrayList<T>(size);
		blackhole.consume(newList);
	}

	@Benchmark
	public void addAll() {
		List<T> newList = new ArrayList<T>(size);
		for(int i = 0; i < size; i++) {
			blackhole.consume(newList.add(values[i]));
		}
	}

	@Benchmark
	public void copyList() {
		List<T> newList = new ArrayList<T>(fullList);
		blackhole.consume(newList);
	}
	
}
