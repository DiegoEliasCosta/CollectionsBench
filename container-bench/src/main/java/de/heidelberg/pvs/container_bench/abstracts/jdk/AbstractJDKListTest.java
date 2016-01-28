package de.heidelberg.pvs.container_bench.abstracts.jdk;

import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;

import de.heidelberg.pvs.container_bench.abstracts.AbstractListTest;

/**
 * Abstract class for every test with JDK Lists implementation
 * @author Diego
 *
 * @param <T>
 * 		The held type of the {@link List} implementation
 */
public abstract class AbstractJDKListTest<T> extends AbstractListTest<T> {
	
	private List<T> fullList;
	private T[] values;
	
	protected abstract List<T> getNewList(int size);
	protected abstract List<T> copyList(List<T> fullList2);
	
	public void testSetup() {
		fullList = this.getNewList(size);
		values = generator.generateArray(size);
		for(int i = 0; i < size; i++) {
			fullList.add(values[i]);
		}
	}
	
	@Benchmark
	public void getAll() {
		for(T element : fullList) {
			blackhole.consume(element);
		}
	}
	
	@Benchmark
	public void getElement() {
		Integer index = generator.generateIndex(size);
		blackhole.consume(fullList.get(index));
	}

	@Benchmark
	public void removeElement() {
		Integer index = generator.generateIndex(size);
		blackhole.consume(fullList.remove(index));
	}

	@Benchmark
	public void containsElement() {
		Integer index = generator.generateIndex(size);
		blackhole.consume(fullList.contains(values[index]));
	}

	@Benchmark
	public void addAll() {
		List<T> newList = this.getNewList(size);
		for(int i = 0; i < size; i++) {
			blackhole.consume(newList.add(values[i]));
		}
		blackhole.consume(newList);
	}

	@Benchmark
	public void copyList() {
		List<T> newList = this.copyList(fullList);
		blackhole.consume(newList);
	}

	
}
