package de.heidelberg.pvs.container_bench.abstracts;

import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

/**
 * Abstract class for every test with JDK Lists implementation
 * @author Diego
 *
 * @param <T>
 * 		The held type of the {@link List} implementation
 */
public abstract class AbstractJDKListTest<T> extends AbstractListTest {
	
	private List<T> fullList;
	private T[] values;
	
	private static Blackhole blackhole;
	
	public void setup() {
		fullList = this.getNewList(size);
		values = this.generateRandomArray(size);
		for(int i = 0; i < size; i++) {
			fullList.add(values[i]);
		}
	}
	
	protected abstract T[] generateRandomArray(int size);
	protected abstract Integer generateRandomIndex(int size);
	
	protected abstract List<T> getNewList(int size);
	protected abstract List<T> copyList(List<T> fullList2);
	
	@Benchmark
	public void getAll() {
		for(int i = 0; i < size; i++) {
			blackhole.consume(fullList.get(i));
		}
	}
	
	@Benchmark
	public void getElement() {
		Integer index = this.generateRandomIndex(size);
		blackhole.consume(fullList.get(index));
	}

	@Benchmark
	public void removeElement() {
		Integer index = this.generateRandomIndex(size);
		blackhole.consume(fullList.remove(index));
	}

	@Benchmark
	public void clear() {
		fullList.clear(); //void
	}

	@Benchmark
	public void containsElement() {
		Integer index = this.generateRandomIndex(size);
		blackhole.consume(fullList.contains(values[index]));
	}

	@Benchmark
	public void instantiate() {
		List<T> newList = this.getNewList(size);
		blackhole.consume(newList);
	}

	@Benchmark
	public void addAll() {
		List<T> newList = this.getNewList(size);
		for(int i = 0; i < size; i++) {
			blackhole.consume(newList.add(values[i]));
		}
	}

	@Benchmark
	public void copyList() {
		List<T> newList = this.copyList(fullList);
		blackhole.consume(newList);
	}

	
}
