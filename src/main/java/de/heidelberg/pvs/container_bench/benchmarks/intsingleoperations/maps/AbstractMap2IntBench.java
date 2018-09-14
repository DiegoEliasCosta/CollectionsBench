package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.maps;

import java.io.IOException;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.AbstractIntSingleOperationsBench;
import de.heidelberg.pvs.container_bench.generators.ElementGenerator;
import de.heidelberg.pvs.container_bench.generators.GeneratorFactory;
import de.heidelberg.pvs.container_bench.generators.IntElementGenerator;
import de.heidelberg.pvs.container_bench.generators.PayloadType;

/**
 * Abstract class for single operation benchmarks on map 2 primitives
 * 
 * @author diego.costa
 *
 */
public abstract class AbstractMap2IntBench extends AbstractIntSingleOperationsBench {

	protected IntElementGenerator valuesGenerator;
	protected ElementGenerator<String> keyGenerator;
	
	@Param
	public Map2IntWorload workload;
	
	protected int values[];
	protected Object keys[];

	@SuppressWarnings("unchecked")
	public void generatorSetup() throws IOException {
		valuesGenerator = GeneratorFactory.buildRandomGenerator(payloadType);
		valuesGenerator.init(size, seed);

		keyGenerator = 
				(ElementGenerator<String>) GeneratorFactory.buildRandomGenerator(PayloadType.STRING_DICTIONARY);
		keyGenerator.init(size, seed);
		
		values = valuesGenerator.generateIntArray(size);
		keys = keyGenerator.generateArray(size);
	}

	
	@Benchmark
	public void bench() {
		workload.run(this);
	}
	
	public enum Map2IntWorload {
		
		POPULATE {
			@Override
			void run(AbstractMap2IntBench self) {
				self.populateBench();
			}
		}, 
		
		ITERATE_KEY {
			@Override
			void run(AbstractMap2IntBench self) {
				self.iterateKeyBench();
			}
			
		},
		
		ITERATE_KEYVALUE {
			@Override
			void run(AbstractMap2IntBench self) {
				self.iterateKeyValueBench();
			}
			
		},
		
		COPY {
			@Override
			void run(AbstractMap2IntBench self) {
				self.copyBench();
			}
			
		}, 
		
		CONTAINS {
			@Override
			void run(AbstractMap2IntBench self) {
				self.containsBench();
			}
		}
		;
		
		abstract void run(AbstractMap2IntBench self);
		
	}

	protected abstract void populateBench();
	protected abstract void containsBench();
	protected abstract void copyBench();
	protected abstract void iterateKeyBench();
	protected abstract void iterateKeyValueBench();
	
}
