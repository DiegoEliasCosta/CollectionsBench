package de.heidelberg.pvs.container_bench.benchmarks.singleoperations.sets;

import java.util.Set;

import org.openjdk.jmh.annotations.Benchmark;

import com.carrotsearch.hppc.ObjectHashSet;
import com.carrotsearch.hppc.ObjectSet;
import com.carrotsearch.hppc.cursors.ObjectCursor;

/**
 * Abstract class for every test with HPPC Sets implementation
 * @author Diego
 *
 * @param <T>
 * 		The held type of the {@link Set} implementation
 */
public abstract class AbstractHPPCSetBench<T> extends AbstractSetBench<T> {
	
	private ObjectSet<T> fullSet;
	private T[] values;
	private T[] newValues;
	private int newValuesSize;
	
	protected abstract ObjectSet<T> getNewSet();
	
	protected abstract ObjectSet<T> copySet(ObjectSet<T> original);
	
	
	public void testSetup() {
		newValuesSize = 2 * size; // 50% of colision
		fullSet = this.getNewSet();
		values = generator.generateArray(size);
		newValues = generator.generateArray(2 * size);
		for(int i = 0; i < size; i++) {
			fullSet.add(values[i]);
		}
	}
	
	@Benchmark
	public void iterate() { 
		for(ObjectCursor<T> element : fullSet) {
			blackhole.consume(element);
		}
	}
	
	
	@Benchmark
	public void containsElement() {
		int index = generator.generateIndex(size);
		blackhole.consume(fullSet.contains(values[index]));
	}


	@Benchmark
	public void populate() {
		ObjectSet<T> newSet = this.getNewSet();
		for(int i = 0; i < size; i++) {
			newSet.add(values[i]);
		}
		blackhole.consume(newSet);
	}
	
	@Benchmark
	public void addElement() {
		int index = this.generator.generateIndex(newValuesSize);
		blackhole.consume(this.fullSet.add(newValues[index]));
		// Had to use removeAll from HPPC API
		blackhole.consume(this.fullSet.removeAll(newValues[index])); 
	}

	@Benchmark
	public void copy() {
		ObjectSet<T> newSet = this.copySet(fullSet);
		blackhole.consume(newSet);
	}
	
	@Override
	@Benchmark
	public void removeElement() {
		int index = this.generator.generateIndex(size);
		// Had to use removeAll from HPPC API
		blackhole.consume(this.fullSet.removeAll(values[index]));
		blackhole.consume(this.fullSet.add(values[index])); // Keeping the steady-state
	}
	
	@Override
	protected Object getFullCollection() {
		return fullSet;
	}
}