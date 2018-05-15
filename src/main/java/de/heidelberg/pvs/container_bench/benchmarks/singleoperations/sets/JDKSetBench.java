package de.heidelberg.pvs.container_bench.benchmarks.singleoperations.sets;

import java.util.Set;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.JDKSetFact;


public abstract class JDKSetBench extends AbstractSetBench<Object> {
	
	private Set<Object> fullSet;
	protected Object[] values;
	private Object[] newValues;
	
	@Param
	JDKSetFact impl;
	
	@Param
	SingleOperationWorkload workload;
	
	@SuppressWarnings("unchecked")
	protected Set<Object> getNewSet() {
		// FIXME: Find a better way to avoid this casting
		return (Set<Object>) impl.maker.get();
	}
	
	protected Set<Object> copySet(Set<Object> fullSet2) {
		Set<Object> set = this.getNewSet();
		set.addAll(fullSet2);
		return set;
	}
	
	public void testSetup() {
		fullSet = this.getNewSet();
		values = generator.generateArray(size);
		newValues = generator.generateArray(2 * size);
		for(int i = 0; i < size; i++) {
			fullSet.add(values[i]);
		}
	}
	
	private enum SingleOperationWorkload {
		
		POPULATE {
			@Override
			void run(JDKSetBench self) {
				Set<Object> newSet = self.getNewSet();
				for(int i = 0; i < self.size; i++) {
					newSet.add(self.values[i]);
				}
				self.blackhole.consume(newSet);
			}
			
		}, //
		
		ITERATE {
			@Override
			void run(JDKSetBench self) {
				for(Object element : self.fullSet) {
					self.blackhole.consume(element);
				}
			}
			
		}, 
		
		COPY {
			@Override
			void run(JDKSetBench self) {
				Set<Object> newSet = self.copySet(self.fullSet);
				self.blackhole.consume(newSet);
			}
		}, 
		
		CONTAINS {

			@Override
			void run(JDKSetBench self) {
				int index = self.generator.generateIndex(self.size);
				self.blackhole.consume(self.fullSet.contains(self.values[index]));
			}
		}
		
		;
		
		abstract void run(JDKSetBench self);
		
	}
	
}