package de.heidelberg.pvs.container_bench.abstracts.hppc;

import org.openjdk.jmh.annotations.Benchmark;

import com.carrotsearch.hppc.ObjectArrayList;
import com.carrotsearch.hppc.cursors.ObjectCursor;

import de.heidelberg.pvs.container_bench.abstracts.AbstractListBench;

public abstract class AbstractHPPCListBench<T> extends AbstractListBench<T> {

	ObjectArrayList<T> fullList;
	T[] values;

	protected abstract ObjectArrayList<T> getNewList(int size);
	protected abstract ObjectArrayList<T> copyList(ObjectArrayList<T> original);
	
	@Override
	public void testSetup() {
		fullList = this.getNewList(size);
		values = this.generator.generateArray(size);
		for (int i = 0; i < size; i++) {
			fullList.add(values[i]);
		}

	}

	@Override
	@Benchmark
	public void iterate() {
		for (ObjectCursor<T> element : fullList) {
			blackhole.consume(element);
		}

	}

	@Override
	@Benchmark
	public void getElement() {
		int index = generator.generateIndex(size);
		blackhole.consume(fullList.get(index));
	}

	@Override
	@Benchmark
	public void containsElement() {
		int index = generator.generateIndex(size);
		blackhole.consume(fullList.contains(values[index]));
	}

	@Override
	@Benchmark
	public void populate() {
		ObjectArrayList<T> newList = new ObjectArrayList<>();
		for (int i = 0; i < size; i++) {
			newList.add(values[i]); // void
		}
		blackhole.consume(newList);
	}

	@Override
	@Benchmark
	public void copy() {
		ObjectArrayList<T> newList = new ObjectArrayList<>(fullList);
		blackhole.consume(newList);
	}
	
	@Override
	@Benchmark
	public void addElement() {
		int index = generator.generateIndex(size);
		fullList.add(values[index]);
		blackhole.consume(fullList.remove(size)); 
	}
	
	@Override
	@Benchmark
	public void removeElement() {
		int index = generator.generateIndex(size);
		blackhole.consume(fullList.removeFirst(values[index]));
		fullList.add(values[index]); // void
	}

	@Override
	protected Object getFullCollection() {
		return fullList;
	}

}
