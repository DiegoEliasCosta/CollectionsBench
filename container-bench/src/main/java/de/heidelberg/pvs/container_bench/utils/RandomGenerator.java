package de.heidelberg.pvs.container_bench.utils;

import java.util.Random;


// FIXME: Find the best way to deal with random numbers in Java
public class RandomGenerator {
	

	public static Integer[] generateIntegers(int randomSeed, int size) {
		Integer[] values = new Integer[size];
		Random generator = new Random(randomSeed);
		for(int i = 0; i < size; i++) {
			values[i] = generator.nextInt();
		}
		return values;
	}
	
	public static Integer generateInteger(int randomSeed, int size) {
		Random generator = new Random(randomSeed);
		return generator.nextInt(size);
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
