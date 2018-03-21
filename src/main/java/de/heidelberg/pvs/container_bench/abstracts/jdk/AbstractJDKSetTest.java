package de.heidelberg.pvs.container_bench.abstracts.jdk;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jol.info.GraphLayout;

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
	protected T[] values;
	private T[] newValues;
	private int newValuesSize;
	
	public void testSetup() {
		newValuesSize = 2 * size; // 50% of colision
		fullSet = this.getNewSet();
		values = generator.generateArray(size);
		newValues = generator.generateArray(2 * size);
		for(int i = 0; i < size; i++) {
			fullSet.add(values[i]);
		}
	}
	
	protected abstract Set<T> getNewSet();
	protected abstract Set<T> copySet(Set<T> fullSet2);
	
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
		Integer index = generator.generateIndex(size);
		blackhole.consume(fullSet.contains(values[index]));
	}

	@Override
	@Benchmark
	public void populate() {
		Set<T> newSet = this.getNewSet();
		for(int i = 0; i < size; i++) {
			newSet.add(values[i]);
		}
		blackhole.consume(newSet);
	}
	
	@Override
	@Benchmark
	public void addElement() {
		Integer index = this.generator.generateIndex(newValuesSize);
		blackhole.consume(this.fullSet.add(newValues[index]));
		blackhole.consume(this.fullSet.remove(newValues[index]));
	}

	@Override
	@Benchmark
	public void copy() {
		Set<T> newSet = this.copySet(fullSet);
		blackhole.consume(newSet);
	}
	
	
	@Override
	@Benchmark
	public void removeElement() {
		Integer index = this.generator.generateIndex(size);
		blackhole.consume(this.fullSet.remove(values[index]));
		blackhole.consume(this.fullSet.add(values[index])); // Keeping the steady-state
	}
	
	@Override
	protected Object getFullCollection() {
		return fullSet;
	}
	
	@Benchmark
	public void reportBoundedCollectionFootprint() throws IOException {
		Set<T> fullCollection = getNewSet();
		
		for (int i = 0; i < size; i++) {
			fullCollection.add(values[i]);
		}

		// Write to the file
		String footprint = String.format("%s\n%s", fullCollection.getClass().getName(),
				GraphLayout.parseInstance(fullCollection).toFootprint());
		
		try(PrintWriter printWriter = new PrintWriter(new FileWriter(this.memoryFootprintFile, true))) {
			printWriter.write(footprint);
		}
	}
}