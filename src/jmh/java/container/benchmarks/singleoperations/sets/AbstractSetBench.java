package container.benchmarks.singleoperations.sets;

import java.io.IOException;

import container.benchmarks.singleoperations.AbstractSingleOperationsBench;
import container.generators.ElementGenerator;
import container.generators.GeneratorFactory;

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