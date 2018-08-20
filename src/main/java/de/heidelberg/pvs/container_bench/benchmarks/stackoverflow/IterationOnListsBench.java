package de.heidelberg.pvs.container_bench.benchmarks.stackoverflow;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.infra.Blackhole;

import de.heidelberg.pvs.container_bench.benchmarks.sets.AbstractWordSetBenchmark;
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
public class IterationOnListsBench extends AbstractSingleOperationsBench {

	/**
	 * Type of the payload object
	 */
	@Param()
	public PayloadType payloadType;

	@Param
	JDKListFact impl;
	private ElementGenerator<Object> generator;
	
	@Param
	private ListIterationWorkload workload;

	private Object values[];
	private List<Object> fullList;

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

	public enum ListIterationWorkload {

		BASIC_FOOR_LOOP {
			@Override
			public void run(IterationOnListsBench self) throws InterruptedException {
				for(int i = 0; i < self.size; i ++) {
					self.blackhole.consume(self.fullList.get(i));
				}
			}
		}, //
		
		ENHANCED_FOOR_LOOP {
			@Override
			public void run(IterationOnListsBench self) throws InterruptedException {
				for (Object i : self.fullList) {
					self.blackhole.consume(i);
				}
			}
		},
		
		ITERATOR_LOOP {
			@Override
			public void run(IterationOnListsBench self) throws InterruptedException {
				for (Iterator<Object> iter = self.fullList.iterator(); iter.hasNext();) {
					self.blackhole.consume(iter.next());
				}
			}
		}, //
		
		LIST_ITERATOR_LOOP {
			
			@Override
			public void run(IterationOnListsBench self) throws InterruptedException {
				for (Iterator<Object> iter = self.fullList.listIterator(); iter.hasNext();) {
					self.blackhole.consume(iter.next());
				}
			}
			
		}, //
		
		
		STREAM_FOR_EACH {

			@Override
			public void run(IterationOnListsBench self) throws InterruptedException {
				self.fullList.stream().forEach(elem -> self.blackhole.consume(elem));
				
			}
			
		}, //
		
		ITERABLE_FOREACH {

			@Override
			public void run(IterationOnListsBench self) throws InterruptedException {
				self.fullList.forEach(elem -> self.blackhole.consume(elem));
			}
			
		}, 
		
		PARALLEL_STREAM {

			@Override
			public void run(IterationOnListsBench self) throws InterruptedException {
				self.fullList.parallelStream().forEach(elem -> self.blackhole.consume(elem));
				
			}
			
		};

		abstract public void run(IterationOnListsBench self) throws InterruptedException;
		
	}


}
