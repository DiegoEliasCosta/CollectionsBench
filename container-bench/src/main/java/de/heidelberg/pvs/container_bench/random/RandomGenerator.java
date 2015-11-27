package de.heidelberg.pvs.container_bench.random;

public interface RandomGenerator<T> {
	
	void setSeed(int seed);
	
	int generateIndex(int range);
	
	T generate();
	T[] generateArray(int arraySize);
	
	T generateInRange(int range);
	T[] generateArrayInRange(int arraySize, int range);

}
