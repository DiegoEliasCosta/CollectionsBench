package container.benchmarks.singleoperations.lists;

import java.io.IOException;

import container.benchmarks.singleoperations.AbstractSingleOperationsBench;
import container.generators.ElementGenerator;
import container.generators.GeneratorFactory;

public abstract class AbstractListBench<T> extends AbstractSingleOperationsBench {

	protected ElementGenerator<T> generator;

	@Override
	@SuppressWarnings("unchecked") //  generator
	public void generatorSetup() throws IOException {
		generator = (ElementGenerator<T>) GeneratorFactory.buildRandomGenerator(payloadType);
		generator.init(size, seed);
	}
	
}