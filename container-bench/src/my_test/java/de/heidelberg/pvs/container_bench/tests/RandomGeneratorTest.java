package de.heidelberg.pvs.container_bench.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import de.heidelberg.pvs.container_bench.utils.ApacheRandomGenerator;
import de.heidelberg.pvs.container_bench.utils.JDKRandomGenerator;
import de.heidelberg.pvs.container_bench.utils.RandomGenerator;

public class RandomGeneratorTest {

	@Test
	public void testRandomnessJDK() throws Exception {

		int n = 100000000;
		int range = 100;
		double tolerance = 0.0079;
		
		RandomGenerator randomGenerator = new JDKRandomGenerator();
		randomGenerator.initializeSeed(0);

		Integer[] randomInts = randomGenerator.generateIntegersInRange(n, range);
		this.testRandomness(randomInts, n, range, tolerance);

	}
	
	
	@Test
	public void testRandomnessApacheCommon() throws Exception {

		int n = 100000000;
		int range = 100;
		double tolerance = 0.09;
		
		RandomGenerator randomGenerator = new ApacheRandomGenerator();
		randomGenerator.initializeSeed(0);

		Integer[] randomInts = randomGenerator.generateIntegersInRange(n, range);
		this.testRandomness(randomInts, n, range, tolerance);

	}

	private void testRandomness(Integer[] randomInts, int n, int range, double tolerance) {
		// Qty test
		assertEquals(randomInts.length, n);

		// Range Test
		boolean found = findNumberGreaterOrEqualThan(range, randomInts);
		assertFalse(found);

		// Range Test 2
		found = findNumberSmallerOrEqualThan(-1, randomInts);
		assertFalse(found);

		for (int i = 0; i < range; i++) {
			// Distribution Test
			int count = countValuesEqualTo(i, randomInts);
//			System.out.println(String.format("%s %s", i, count));
			assertEquals(count > n / range * (1 + tolerance), false);
			assertEquals(count < n / range * (1 - tolerance), false);
		}
	}

	private int countValuesEqualTo(int i, Integer[] randomInts) {
		int count = 0;
		for (int j = 0; j < randomInts.length; j++) {
			if (randomInts[j] == i) {
				count++;
			}
		}
		return count;
	}

	private boolean findNumberSmallerOrEqualThan(int i, Integer[] randomInts) {
		for (int j = 0; j < randomInts.length; j++) {
			if (randomInts[j] <= i) {
				return true;
			}
		}
		return false;
	}

	private boolean findNumberGreaterOrEqualThan(int i, Integer[] randomInts) {
		for (int j = 0; j < randomInts.length; j++) {
			if (randomInts[j] >= i) {
				return true;
			}
		}
		return false;
	}

}
