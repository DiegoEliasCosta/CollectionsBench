package de.heidelberg.pvs.container_bench.benchmarks.singleoperations.sets;

import java.io.IOException;

import de.heidelberg.pvs.container_bench.benchmarks.singleoperations.AbstractSingleOperationsBench;
import de.heidelberg.pvs.container_bench.generators.ElementGenerator;
import de.heidelberg.pvs.container_bench.generators.GeneratorFactory;

public abstract class AbstractSetBench<T> extends AbstractSingleOperationsBench {

	/**
	 * Implementation of our Randomness
	 */
	protected ElementGenerator<T> generator;

	@SuppressWarnings("unchecked")
	@Override
	public void generatorSetup() throws IOException {
		generator = (ElementGenerator<T>) GeneratorFactory.buildRandomGenerator(payloadType);
		generator.init(size, seed);
	}

}