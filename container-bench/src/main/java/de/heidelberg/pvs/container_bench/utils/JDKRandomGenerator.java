package de.heidelberg.pvs.container_bench.utils;

import java.util.Random;

public class JDKRandomGenerator implements RandomGenerator {
	
	private final int NO_RANGE_FLAG = -1;

	private Random generator;

	@Override
	public void initializeSeed(int seed) {
		this.generator = new Random(seed);
	}
	
	
	@Override
	public Integer[] generateIntegersInRange(int seed, int size, int range) {
		Integer[] values = new Integer[size];
		
		// No range specified
		if (range == NO_RANGE_FLAG) {
			for (int i = 0; i < size; i++) {
				values[i] = generator.nextInt();
			}

		} else {
			// Range specified
			for (int i = 0; i < size; i++) {
				values[i] = generator.nextInt(range);
			}
		}
		return values;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.heidelberg.pvs.container_bench.utils.RandomGenerator#generateIntegers(
	 * int, int)
	 */
	@Override
	public Integer[] generateIntegers(int seed, int size) {
		Integer[] values = new Integer[size];
		for (int i = 0; i < size; i++) {
			values[i] = generator.nextInt();
		}
		return generateIntegersInRange(seed, size, NO_RANGE_FLAG);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.heidelberg.pvs.container_bench.utils.RandomGenerator#generateInteger(
	 * int, int)
	 */
	@Override
	public Integer generateIntegerInRange(int seed, int range) {
		return generator.nextInt(range);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.heidelberg.pvs.container_bench.utils.RandomGenerator#generateStrings(
	 * int, int)
	 */
	@Override
	public String[] generateStrings(int seed, int size) {
		String[] values = new String[size];
		for (int i = 0; i < size; i++) {
			values[i] = "" + generator.nextLong();
		}
		return values;
	}

}
