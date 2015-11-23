package de.heidelberg.pvs.container_bench.utils;

import org.apache.commons.math3.random.Well44497b;

public class ApacheRandomGenerator implements RandomGenerator {

	private static final int NO_RANGE_FLAG = -1;

	Well44497b generator;

	@Override
	public void initializeSeed(int seed) {
		this.generator = new Well44497b(seed);
	}

	@Override
	public Integer[] generateIntegersInRange(int size, int range) {

		Integer[] integers = new Integer[size];

		for (int i = 0; i < size; i++) {
			integers[i] = generator.nextInt(range);
		}

		return integers;
	}

	@Override
	public Integer[] generateIntegers(int size) {

		Integer[] integers = new Integer[size];

		for (int i = 0; i < size; i++) {
			integers[i] = generator.nextInt();
		}

		return integers;
	}

	@Override
	public Integer generateIntegerInRange(int range) {
		return generator.nextInt(range);
	}

	@Override
	public String[] generateStrings(int size) {
		String[] strings = new String[size];

		for (int i = 0; i < size; i++) {
			strings[i] = "" + generator.nextLong();
		}

		return strings;
	}

	@Override
	public Integer generateInteger() {
		return generator.nextInt();
	}

}
