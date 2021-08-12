package de.heidelberg.pvs.container_bench.benchmarks.singleoperations.lists;

import java.io.IOException;

import de.heidelberg.pvs.container_bench.benchmarks.singleoperations.AbstractSingleOperationsBench;
import de.heidelberg.pvs.container_bench.generators.ElementGenerator;
import de.heidelberg.pvs.container_bench.generators.GeneratorFactory;

public abstract class AbstractListBench<T> extends AbstractSingleOperationsBench {

	protected ElementGenerator<T> generator;

	@Override
	@SuppressWarnings("unchecked") //  generator
	public void generatorSetup() throws IOException {
		generator = (ElementGenerator<T>) GeneratorFactory.buildRandomGenerator(payloadType);
		generator.init(size, seed);
	}
	
}