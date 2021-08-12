package de.heidelberg.pvs.container_bench.benchmarks.singleoperations.lists;

import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.JDKListFact;

/**
 * Single operations benchmark for JDK Lists implementation
 * 
 * @author Diego
 */
public class JDKListBench extends AbstractListBench<Object> {

	private List<Object> fullList;
	protected Object[] values;

	@Param
	public JDKListWorkload workload; 
	
	@Param
	public JDKListFact impl;
	
	protected List<Object> getNewList() {
		return impl.maker.get();
	}

	@Override
	public void testSetup() {
		fullList = this.getNewList();
		values = generator.generateArray(size);
		for (int i = 0; i < size; i++) {
			fullList.add(values[i]);
		}
	}

	@Benchmark
	public void bench() {
		workload.run(this);
		blackhole.consume(fullList);
	}

	protected List<Object> copyList(List<Object> fullList2) {
		List<Object> list = this.getNewList();
		list.addAll(fullList2);
		return list;
	}
	
	public enum JDKListWorkload {

		ITERATE {
			@Override
			public void run(JDKListBench self) {
				for (Object element : self.fullList) {
					self.blackhole.consume(element);
				}
			}
		}, //

		GET_INDEX {

			@Override
			public void run(JDKListBench self) {
				int index = self.generator.generateIndex(self.size);
				self.blackhole.consume(self.fullList.get(index));
			}
		}, //

		CONTAINS {

			@Override
			public void run(JDKListBench self) {
				int index = self.generator.generateIndex(self.size);
				self.blackhole.consume(self.fullList.contains(self.values[index]));

			}

		}, //

		POPULATE {

			@Override
			public void run(JDKListBench self) {
				List<Object> newList = self.getNewList();
				for (int i = 0; i < self.size; i++) {
					newList.add(self.values[i]);
				}
				self.blackhole.consume(newList);
			}

		}, //
		
		COPY {

			@Override
			public void run(JDKListBench self) {
				List<Object> newList = self.copyList(self.fullList);
				self.blackhole.consume(newList);
			}
		}, 
		
		// TODO: Add more scenarios for single operation

		;

		abstract public void run(JDKListBench self);

	}


}
