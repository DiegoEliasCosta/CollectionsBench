package de.heidelberg.pvs.container_bench.generators;

import de.heidelberg.pvs.container_bench.generators.dictionary.StringDictionaryGenerator;
import de.heidelberg.pvs.container_bench.generators.uniform.IntegerUniformGenerator;
import de.heidelberg.pvs.container_bench.generators.uniform.StringUniformGenerator;

public class GeneratorFactory {

	public static ElementGenerator<?> buildRandomGenerator(PayloadType payloadType) {
		
		switch(payloadType) {
		
		case INTEGER_UNIFORM:
			return new IntegerUniformGenerator();
			
		case STRING_UNIFORM:
			return new StringUniformGenerator();
			
		case DICTIONARY_STRING:
			return new StringDictionaryGenerator();
		
		default:
			throw new IllegalArgumentException(String.format("Payload type not specified"));
		}
		
		
	}
	

}
