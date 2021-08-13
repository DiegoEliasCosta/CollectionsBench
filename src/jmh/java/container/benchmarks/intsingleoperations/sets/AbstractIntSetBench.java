package container.benchmarks.intsingleoperations.sets;

import java.io.IOException;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

import container.benchmarks.intsingleoperations.AbstractIntSingleOperationsBench;
import container.generators.GeneratorFactory;
import container.generators.IntElementGenerator;

public abstract class AbstractIntSetBench extends AbstractIntSingleOperationsBench{

	protected IntElementGenerator generator;
	
	@Param
	public IntSetWorload workload;
	
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
	
	public enum IntSetWorload {
		
		POPULATE {
			@Override
			void run(AbstractIntSetBench self) {
				self.populateBench();
			}
		}, 
		
		ITERATE {
			@Override
			void run(AbstractIntSetBench self) {
				self.iterateBench();
			}
			
		}, 
		
		COPY {
			@Override
			void run(AbstractIntSetBench self) {
				self.copyBench();
			}
			
		}, 
		
		CONTAINS {
			@Override
			void run(AbstractIntSetBench self) {
				self.containsBench();
			}
		}
		;
		
		abstract void run(AbstractIntSetBench self);
		
	}

	protected abstract void populateBench();

	protected abstract void containsBench();
		
	protected abstract void copyBench();

	protected abstract void iterateBench();
	
}
