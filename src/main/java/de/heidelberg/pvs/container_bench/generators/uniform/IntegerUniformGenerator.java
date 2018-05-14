package de.heidelberg.pvs.container_bench.generators.uniform;

public class IntegerUniformGenerator extends AbstractUniformGenerator<Integer> {

	@Override
	public Integer[] generateArray(int arraySize) {
		Integer[] integers = new Integer[arraySize];
		for (int i = 0; i < arraySize; i++) {
			integers[i] = generator.nextInt();
		}
		return integers;
	}

	@Override
	public Integer[] generateArrayFromPool(int arraySize, int range) {
		Integer[] integers = new Integer[arraySize];
		for (int i = 0; i < arraySize; i++) {
			integers[i] = generator.nextInt(range);
		}
		return integers;
	}

}
