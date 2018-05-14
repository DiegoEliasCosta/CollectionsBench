package de.heidelberg.pvs.container_bench.generators.uniform;

public class StringUniformGenerator extends AbstractUniformGenerator<String> {
	

	@Override
	public String[] generateArray(int arraySize) {
		String[] strings = new String[arraySize];
		for (int i = 0; i < arraySize; i++) {
			strings[i] = "" + generator.nextLong();
		}
		return strings;
	}

	@Override
	public String[] generateArrayFromPool(int arraySize, int range) {
		String[] strings = new String[arraySize];
		for (int i = 0; i < arraySize; i++) {
			strings[i] = "" + generator.nextLong(range);
		}
		return strings;
	}

}
