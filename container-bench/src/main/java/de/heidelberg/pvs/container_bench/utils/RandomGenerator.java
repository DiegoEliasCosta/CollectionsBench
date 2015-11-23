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
	
	Long[] generateLongsInRange(int n, long range);
	Long[] generateLongs(int size);
	Long generateLongInRange(long range);
	Long generateLong();
	
	// Double[] generateDoublesInRange(int n, double range); // Apache doesn't provide for this
	Double[] generateDoubles(int size);
	// Double generateDoubleInRange(double range); // Appache doesn't provide for this 
	Double generateDouble();
	
	String[] generateStrings(int size);
	
}