package de.heidelberg.pvs.container_bench.utils;

import de.heidelberg.pvs.container_bench.element.Element;

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
	Integer[] generateIntegers(int size);
	Integer generateIntegerInRange(int range);
	Integer generateInteger();
	
	Long[] generateLongsInRange(int n, long range);
	Long[] generateLongs(int size);
	Long generateLongInRange(long range);
	Long generateLong();
	
	Double[] generateDoubles(int size);
	Double generateDouble();
	
	Element[] generateElements(int size);
	Element generateElement();
	
	String[] generateStrings(int size);
	String generateString();
	
}