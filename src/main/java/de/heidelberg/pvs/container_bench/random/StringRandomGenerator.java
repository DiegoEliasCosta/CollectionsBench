package de.heidelberg.pvs.container_bench.random;

public class StringRandomGenerator extends AbstractRandomGenerator<String> {

	
	@Override
	public String generate() {
		return "" + generator.nextLong();
	}

	@Override
	public String[] generateArray(int arraySize) {
		String[] strings = new String[arraySize];
		for (int i = 0; i < arraySize; i++) {
			strings[i] = "" + generator.nextLong();
		}
		return strings;
	}

	@Override
	public String generateInRange(int range) {
		return "" + generator.nextLong(range);
	}

	@Override
	public String[] generateArrayInRange(int arraySize, int range) {
		String[] strings = new String[arraySize];
		for (int i = 0; i < arraySize; i++) {
			strings[i] = "" + generator.nextLong(range);
		}
		return strings;
	}

}
