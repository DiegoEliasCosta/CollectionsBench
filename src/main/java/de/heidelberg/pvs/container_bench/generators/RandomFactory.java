package de.heidelberg.pvs.container_bench.generators;

import com.google.common.reflect.TypeToken;

import de.heidelberg.pvs.container_bench.generators.uniform.IntegerUniformGenerator;
import de.heidelberg.pvs.container_bench.generators.uniform.LongUniformGenerator;
import de.heidelberg.pvs.container_bench.generators.uniform.StringUniformGenerator;

public class RandomFactory {

	public static ElementGenerator<?> buildRandomGenerator(TypeToken<?> type) {
		
		if (type == null) {
			throw new RuntimeException("The TypeToken for the class was not specified. Aborting benchmark");
		}
		
		Class<?> rawType = type.getRawType();
		
		if (rawType.equals(Integer.class)) {
			return new IntegerUniformGenerator();
		}
		
		if (rawType.equals(String.class)) {
			return new StringUniformGenerator();
		}
		
		if (rawType.equals(Long.class)) {
			return new LongUniformGenerator();
		}
		
		throw new IllegalArgumentException(String.format("Type %s is not supported by the Benchmark", rawType));
	}
	
	
	

}
