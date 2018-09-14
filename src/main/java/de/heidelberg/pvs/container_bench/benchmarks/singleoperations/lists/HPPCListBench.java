package de.heidelberg.pvs.container_bench.benchmarks.singleoperations.lists;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.ObjectIndexedContainer;
import com.carrotsearch.hppc.cursors.ObjectCursor;

import de.heidelberg.pvs.container_bench.factories.HPPCListFact;

public class HPPCListBench extends AbstractListBench<Object> {

	ObjectIndexedContainer<Object> fullList;
	Object[] values;
	
	@Param
	public HPPCListFact impl;
	
	@Param
	public HPPCListWorkload workload;
	
	protected ObjectIndexedContainer<Object> getNewList() {
		return impl.maker.get();
	}

	protected ObjectIndexedContainer<Object> copyList(ObjectIndexedContainer<Object> original) {
		return impl.copyMaker.apply(original);
	}
	
	@Override
	public void testSetup() {
		fullList = this.getNewList();
		values = this.generator.generateArray(size);
		for (int i = 0; i < size; i++) {
			fullList.add(values[i]);
		}

	}
	
	@Benchmark
	public void bench() {
		workload.run(this);
		blackhole.consume(fullList);
	}
	
	public enum HPPCListWorkload {

		ITERATE {
			@Override
			public void run(HPPCListBench self) {
				for (ObjectCursor<Object> element : self.fullList) {
					self.blackhole.consume(element.value);
				}
			}
		}, //

		GET_INDEX {

			@Override
			public void run(HPPCListBench self) {
				int index = self.generator.generateIndex(self.size);
				self.blackhole.consume(self.fullList.get(index));
			}
		}, //

		CONTAINS {

			@Override
			public void run(HPPCListBench self) {
				int index = self.generator.generateIndex(self.size);
				self.blackhole.consume(self.fullList.contains(self.values[index]));

			}

		}, //

		POPULATE {

			@Override
			public <T> void run(HPPCListBench self) {
				ObjectIndexedContainer<Object> newList = self.getNewList();
				for (int i = 0; i < self.size; i++) {
					newList.add(self.values[i]);
				}
				self.blackhole.consume(newList);
			}

		}, //
		
		COPY {

			@Override
			public void run(HPPCListBench self) {
				ObjectIndexedContainer<Object> newList = self.copyList(self.fullList);
				self.blackhole.consume(newList);
			}
		}, 
		
		// TODO: Add more scenarios for single operation
		;
		
		abstract public <T> void run(HPPCListBench self);
		
	}

}
