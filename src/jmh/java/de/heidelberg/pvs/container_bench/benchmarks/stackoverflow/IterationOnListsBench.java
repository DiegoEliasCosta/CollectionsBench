package de.heidelberg.pvs.container_bench.benchmarks.stackoverflow;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.benchmarks.singleoperations.AbstractSingleOperationsBench;
import de.heidelberg.pvs.container_bench.factories.JDKListFact;
import de.heidelberg.pvs.container_bench.generators.ElementGenerator;
import de.heidelberg.pvs.container_bench.generators.GeneratorFactory;
import de.heidelberg.pvs.container_bench.generators.PayloadType;

/**
 * Benchmark that evaluates the performance of the multitude of ways of
 * iterating on a list according to the Stack Overflow question:
 * https://stackoverflow.com/questions/18410035/ways-to-iterate-over-a-list-in-java
 * 
 * @author diego.costa
 *
 */
public abstract class IterationOnListsBench extends AbstractSingleOperationsBench {

	/**
	 * Type of the payload object
	 */
	@Param()
	public PayloadType payloadType;

	@Param
	JDKListFact impl;
	public ElementGenerator<Object> generator;

	@Param
	public ListIterationWorkload workload;
	public enum ListIterationWorkload { SO_LIST_ITERATE };

	private Object values[];
	protected List<Object> fullList;

	@SuppressWarnings("unchecked")
	@Override
	public void generatorSetup() throws IOException {
		generator = (ElementGenerator<Object>) GeneratorFactory.buildRandomGenerator(payloadType);
		generator.init(size, seed);
	}

	@Override
	public void testSetup() {
		fullList = this.impl.maker.get();
		values = this.generator.generateArray(size);
		for (int i = 0; i < size; i++) {
			fullList.add(values[i]);
		}
	}

	@Benchmark
	public void basicForLoop() {
		for (int i = 0; i < size; i++) {
			blackhole.consume(fullList.get(i));
		}
	}

	@Benchmark
	public void enhancedForLoop() {
		for (Object i : fullList) {
			blackhole.consume(i);
		}
	}

	@Benchmark
	public void iteratorForLoop() {
		for (Iterator<Object> iter = fullList.iterator(); iter.hasNext();) {
			blackhole.consume(iter.next());
		}
	}

	@Benchmark
	public void listIteratorForLoop() {
		for (Iterator<Object> iter = fullList.listIterator(); iter.hasNext();) {
			blackhole.consume(iter.next());
		}
	}

	@Benchmark
	public void streamForEach() {
		fullList.stream().forEach(elem -> blackhole.consume(elem));
	}

	@Benchmark
	public void iterableForEach() {
		fullList.forEach(elem -> blackhole.consume(elem));
	}

	@Benchmark
	public void parallelStream() {
		fullList.parallelStream().forEach(elem -> blackhole.consume(elem));

	}

}
