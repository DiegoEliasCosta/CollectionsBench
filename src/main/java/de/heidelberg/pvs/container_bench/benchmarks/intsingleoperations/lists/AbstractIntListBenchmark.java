package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.lists;

import java.io.IOException;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.AbstractIntSingleOperationsBench;
import de.heidelberg.pvs.container_bench.generators.GeneratorFactory;
import de.heidelberg.pvs.container_bench.generators.IntElementGenerator;

public abstract class AbstractIntListBenchmark extends AbstractIntSingleOperationsBench {
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

	/**
	 * Mapping from the parameter enum to methods calls.
	 */
	public enum IntListWorload {
		POPULATE {
			@Override
			void run(AbstractIntListBenchmark self) {
				self.populateBench();
			}
		},

		ITERATE {
			@Override
			void run(AbstractIntListBenchmark self) {
				self.iterateBench();
			}
		},

		COPY {
			@Override
			void run(AbstractIntListBenchmark self) {
				self.copyBench();
			}
		},

		CONTAINS {
			@Override
			void run(AbstractIntListBenchmark self) {
				self.containsBench();
			}
		};

		abstract void run(AbstractIntListBenchmark self);
	}

	protected abstract void populateBench();

	protected abstract void containsBench();

	protected abstract void copyBench();

	protected abstract void iterateBench();
}
