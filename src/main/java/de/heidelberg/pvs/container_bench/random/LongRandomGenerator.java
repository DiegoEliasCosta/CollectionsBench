package de.heidelberg.pvs.container_bench.random;

public class LongRandomGenerator extends AbstractRandomGenerator<Long> {

	@Override
	public Long generate() {
		return generator.nextLong();
	}

	@Override
	public Long[] generateArray(int arraySize) {
		Long[] longs = new Long[arraySize];
		for (int i = 0; i < arraySize; i++) {
			longs[i] = generator.nextLong();
		}
		return longs;
	}

	@Override
	public Long generateInRange(int range) {
		return generator.nextLong(range);
	}

	@Override
	public Long[] generateArrayInRange(int arraySize, int range) {
		Long[] longs = new Long[arraySize];
		for (int i = 0; i < arraySize; i++) {
			longs[i] = generator.nextLong(range);
		}
		return longs;
	}

}
