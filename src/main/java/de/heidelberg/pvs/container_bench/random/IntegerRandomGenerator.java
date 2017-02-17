package de.heidelberg.pvs.container_bench.random;

public class IntegerRandomGenerator extends AbstractRandomGenerator<Integer> {

	@Override
	public Integer generate() {
		return generator.nextInt();
	}

	@Override
	public Integer[] generateArray(int arraySize) {
		Integer[] integers = new Integer[arraySize];
		for (int i = 0; i < arraySize; i++) {
			integers[i] = generator.nextInt();
		}
		return integers;
	}

	@Override
	public Integer generateInRange(int range) {
		return generator.nextInt(range);
	}

	@Override
	public Integer[] generateArrayInRange(int arraySize, int range) {
		Integer[] integers = new Integer[arraySize];
		for (int i = 0; i < arraySize; i++) {
			integers[i] = generator.nextInt(range);
		}
		return integers;
	}

}
