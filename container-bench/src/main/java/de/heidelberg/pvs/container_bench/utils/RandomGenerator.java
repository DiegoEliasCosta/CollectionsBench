package de.heidelberg.pvs.container_bench.utils;

public interface RandomGenerator {

	void initializeSeed(int seed);
	/**
	 * Generate an array of random integers
	 * 
	 * @param seed
	 *            The seed for the random algorithm
	 * @param n
	 *            The number of required elements
	 * @param range
	 *            The maximum number of the values
	 * @return An array with n elements containing values between 0 (included)
	 *         and range (not included)
	 */
	Integer[] generateIntegersInRange(int n, int range);

	/**
	 * Generate a random integer
	 * 
	 * @param seed
	 * @param size
	 * @return
	 */
	Integer[] generateIntegers(int size);

	Integer generateIntegerInRange(int range);
	
	Integer generateInteger();

	String[] generateStrings(int size);


}