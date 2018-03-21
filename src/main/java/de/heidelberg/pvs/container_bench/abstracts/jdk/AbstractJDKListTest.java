package de.heidelberg.pvs.container_bench.abstracts.jdk;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jol.info.GraphLayout;

import de.heidelberg.pvs.container_bench.abstracts.AbstractListTest;

/**
 * Abstract class for every test with JDK Lists implementation
 * 
 * @author Diego
 *
 * @param <T>
 *            The held type of the {@link List} implementation
 */
public abstract class AbstractJDKListTest<T> extends AbstractListTest<T> {

	private List<T> fullList;
	protected T[] values;

	protected abstract List<T> getNewList();

	protected abstract List<T> copyList(List<T> fullList2);

	@Override
	public void testSetup() {
		fullList = this.getNewList();
		values = generator.generateArray(size);
		for (int i = 0; i < size; i++) {
			fullList.add(values[i]);
		}
	}

	@Override
	@Benchmark
	public void iterate() {
		for (T element : fullList) {
			blackhole.consume(element);
		}
	}

	@Override
	@Benchmark
	public void getElement() {
		Integer index = generator.generateIndex(size);
		blackhole.consume(fullList.get(index));
	}

	@Override
	@Benchmark
	public void containsElement() {
		Integer index = generator.generateIndex(size);
		blackhole.consume(fullList.contains(values[index]));
	}

	@Override
	@Benchmark
	public void populate() {
		List<T> newList = this.getNewList();
		for (int i = 0; i < size; i++) {
			newList.add(values[i]);
		}
		blackhole.consume(newList);
	}

	@Override
	@Benchmark
	public void copy() {
		List<T> newList = this.copyList(fullList);
		blackhole.consume(newList);
	}

	@Override
	@Benchmark
	public void addElement() {
		Integer index = generator.generateIndex(size);
		blackhole.consume(fullList.add(values[index]));
		blackhole.consume(fullList.remove(size));
	}

	@Override
	@Benchmark
	public void removeElement() {
		Integer index = generator.generateIndex(size);
		blackhole.consume(fullList.remove(values[index]));
		blackhole.consume(fullList.add(values[index]));

	}
	
	@Override
	protected Object getFullCollection() {
		return fullList;
	}

	@Benchmark
	public void reportBoundedCollectionFootprint() throws IOException {
		List<T> fullCollection = getNewList();
		
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
