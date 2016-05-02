package de.heidelberg.pvs.container_bench.random;

import com.google.common.reflect.TypeToken;

public class RandomFactory {

	public static RandomGenerator<?> buildRandomGenerator(TypeToken<?> type) {
		
		if (type == null) {
			throw new RuntimeException("The TypeToken for the class was not specified. Aborting benchmark");
		}
		
		Class<?> rawType = type.getRawType();
		
		if (rawType.equals(Integer.class)) {
			return new IntegerRandomGenerator();
		}
		
		if (rawType.equals(String.class)) {
			return new StringRandomGenerator();
		}
		
		if (rawType.equals(Long.class)) {
			return new LongRandomGenerator();
		}
		
		throw new IllegalArgumentException(String.format("Type %s is not supported by the Benchmark", rawType));
	}

}
