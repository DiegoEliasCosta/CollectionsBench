package de.heidelberg.pvs.container_bench.generators;

import java.io.IOException;

/**
 * 
 * Generator of elements (payload) that will be used inside collections 
 * 
 * @author diego.costa
 *
 * @param <T>
 */
public interface ElementGenerator<T> {
	
	/**
	 * Initialize the generator with a specified seed.
	 *  
	 * @poolSize amount of possible elements generated  
	 * @param seed 
	 * @throws IOException 
	 * Dictionary generators require the read of external file (provided within 
	 * collections-bench). 
	 */
	void init(int poolSize, int seed) throws IOException;
	
	int generateIndex(int range);
	
	T[] generateArray(int arraySize);
	
}
