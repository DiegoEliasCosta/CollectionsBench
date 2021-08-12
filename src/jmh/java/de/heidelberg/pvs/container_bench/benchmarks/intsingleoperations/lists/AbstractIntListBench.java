package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.lists;

import java.io.IOException;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.AbstractIntSingleOperationsBench;
import de.heidelberg.pvs.container_bench.generators.GeneratorFactory;
import de.heidelberg.pvs.container_bench.generators.IntElementGenerator;

public abstract class AbstractIntListBench extends AbstractIntSingleOperationsBench { 
	
	/**
	 * Implementation of our Randomness 
	 */
	protected IntElementGenerator generator;
	
	@Param
	public IntListWorload workload;
	
	protected int values[];

	public void generatorSetup() throws IOException {
		generator = GeneratorFactory.buildRandomGenerator(payloadType);
		generator.init(size, seed);
		values = generator.generateIntArray(size);
	}

	
	@Benchmark
	public void bench() {
		workload.run(this);
	}
	
	public enum IntListWorload {
		
		POPULATE {
			@Override
			void run(AbstractIntListBench self) {
				self.populateBench();
			}
		}, 
		
		ITERATE {
			@Override
			void run(AbstractIntListBench self) {
				self.iterateBench();
			}
			
		}, 
		
		COPY {
			@Override
			void run(AbstractIntListBench self) {
				self.copyBench();
			}
			
		}, 
		
		CONTAINS {
			@Override
			void run(AbstractIntListBench self) {
				self.containsBench();
			}
		}
		;
		
		abstract void run(AbstractIntListBench self);
		
	}

	protected abstract void populateBench();

	protected abstract void containsBench();
		
	protected abstract void copyBench();

	protected abstract void iterateBench();

}
