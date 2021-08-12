package de.heidelberg.pvs.container_bench.generators.uniform;

import de.heidelberg.pvs.container_bench.generators.IntElementGenerator;

public class IntegerUniformGenerator extends AbstractUniformGenerator<Integer> implements IntElementGenerator {

	@Override
	public Integer[] generateArray(int arraySize) {
		Integer[] integers = new Integer[arraySize];
		for (int i = 0; i < arraySize; i++) {
			integers[i] = generator.nextInt();
		}
		return integers;
	}

	@Override
	public int[] generateIntArray(int arraySize) {
		int[] integers = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			integers[i] = generator.nextInt();
		}
		return integers;
	}

}
