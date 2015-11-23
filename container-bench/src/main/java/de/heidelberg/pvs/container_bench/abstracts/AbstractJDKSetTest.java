package de.heidelberg.pvs.container_bench.abstracts;

import java.util.Random;
import java.util.Set;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

// Crude copy/paste of AbstractJDKListTest with minor adjustments to get the code to compile. WIP

/**
 * Abstract class for every test with JDK Sets implementation
 * @author Diego
 *
 * @param <T>
 * 		The held type of the {@link Set} implementation
 */
public abstract class AbstractJDKSetTest<T> extends AbstractSetTest {
	
	private Set<T> fullSet;
	private T[] values;
	
	private static Blackhole blackhole;
	
	public void setup() {
		fullSet = this.getNewSet(size);
		values = this.generateRandomArray(size);
		for(int i = 0; i < size; i++) {
			fullSet.add(values[i]);
		}
	}
	
	protected abstract T[] generateRandomArray(int size);
	
	protected abstract Set<T> getNewSet(int size);
	protected abstract Set<T> copySet(Set<T> fullSet2);
	
	@Benchmark
	public void getAll() { // WIP!!!
	for(Object obj: fullSet)
		blackhole.consume(obj);
	}
	
	@Benchmark
	public void getElement() {} /*{
		Integer index = this.generateRandomIndex(size);
		blackhole.consume(fullSet.get(index));
	}*/

	@Benchmark
	public void removeElement() {
		
	int size = fullSet.size();
	int item = new Random().nextInt(size);
	int i = 0;
	for(Object obj : fullSet)
		{
		    if (i == item) {
		        blackhole.consume(fullSet.remove(obj));
		        break;
		    }
		}
	}

	@Benchmark
	public void clear() {
		fullSet.clear(); //void
	}

	@Benchmark
	public void containsElement() {
		Integer index = this.generateRandomIndex(size);
		blackhole.consume(fullSet.contains(values[index]));
	}

	private Integer generateRandomIndex(int size) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Benchmark
	public void instantiate() {
		Set<T> newSet = this.getNewSet(size);
		blackhole.consume(newSet);
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