package de.heidelberg.pvs.container_bench.utils;

import java.util.Random;


// FIXME: Find the best way to deal with random numbers in Java
public class RandomGenerator {
	
	// FIXME: The functions are not been reused for performance reasons 
	public static Integer[] generateIntegers(int seed, int size, int range) {
		Integer[] values = new Integer[size];
		Random generator = new Random(seed);
		for(int i = 0; i < size; i++) {
			values[i] = generator.nextInt(range);
		}
		return values;
	}
	
	public static Integer[] generateIntegers(int seed, int size) {
		Integer[] values = new Integer[size];
		Random generator = new Random(seed);
		for(int i = 0; i < size; i++) {
			values[i] = generator.nextInt();
		}
		return values;
	}
	
	public static Integer generateInteger(int seed, int range) {
		Random generator = new Random(seed);
		return generator.nextInt(range);
	}

	public static String[] generateStrings(int seed, int size) {
		String[] values = new String[size];
		Random generator = new Random(seed);
		for(int i = 0; i < size; i++) {
			values[i] = "" + generator.nextInt();
		}
		return values;
	}

}
