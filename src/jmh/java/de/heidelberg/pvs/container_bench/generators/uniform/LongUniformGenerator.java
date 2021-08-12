package de.heidelberg.pvs.container_bench.generators.uniform;

public class LongUniformGenerator extends AbstractUniformGenerator<Long> {

	@Override
	public Long[] generateArray(int arraySize) {
		Long[] longs = new Long[arraySize];
		for (int i = 0; i < arraySize; i++) {
			longs[i] = generator.nextLong();
		}
		return longs;
	}

}
