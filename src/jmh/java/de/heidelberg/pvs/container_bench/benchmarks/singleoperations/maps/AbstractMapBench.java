package de.heidelberg.pvs.container_bench.benchmarks.singleoperations.maps;

import java.io.IOException;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.benchmarks.singleoperations.AbstractSingleOperationsBench;
import de.heidelberg.pvs.container_bench.generators.ElementGenerator;
import de.heidelberg.pvs.container_bench.generators.GeneratorFactory;
import de.heidelberg.pvs.container_bench.generators.PayloadType;

public abstract class AbstractMapBench<K, V> extends AbstractSingleOperationsBench {

	@Param({ "100" })
	public int percentageRangeKeys;

	protected ElementGenerator<K> keyGenerator;
	protected ElementGenerator<V> valueGenerator;

	/**
	 * Implementation of our Randomness 
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void generatorSetup() throws IOException {
		
		keyGenerator = (ElementGenerator<K>) GeneratorFactory.buildRandomGenerator(payloadType);
		// default value generator
		valueGenerator = (ElementGenerator<V>) GeneratorFactory.buildRandomGenerator(PayloadType.INTEGER_UNIFORM);
		
		keyGenerator.init(size, seed);	
		valueGenerator.init(size, seed);
	}

}
