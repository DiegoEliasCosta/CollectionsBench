package de.heidelberg.pvs.container_bench.random;

import org.apache.commons.math3.random.Well44497b;

public abstract class AbstractRandomGenerator<T> implements RandomGenerator<T> {

	Well44497b generator;
	
	@Override
	public void setSeed(int seed) {
		generator = new Well44497b(seed);
	}
	
	@Override
	public int generateIndex(int range) {
		return generator.nextInt(range);
	}

		

}
