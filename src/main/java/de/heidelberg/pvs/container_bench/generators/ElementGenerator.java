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
	 * @param seed 
	 * @throws IOException 
	 * Dictionary generators require the read of external file (provided within 
	 * collections-bench). 
	 */
	void init(int size, int seed) throws IOException;
	
	int generateIndex(int range);
	
	T[] generateArray(int arraySize);
	
	/**
	 * Generate an array with size {@code @arraySize} and composes the array
	 * with a pool of {@code poolSize} possible elements.
	 * 
	 * The @range controls the pool size from which the objects are **randomly** drawn.
	 * Therefore relation @arraySize and @range controls the variety of elements inside 
	 * the returned array. 
	 *
	 * @range greater than @arraySize ensures a higher chance of unique elements in the array.
	 * Conversely, @range smaller than @arraySize will draw from elements from a smaller pool, 
	 * and will result in repeated elements in the returned array.
	 * 
	 * @param arraySize
	 * 		Size of the returned array
	 * @param poolSize
	 * 		Size of pool in which to draw the elements from 
	 * @return
	 */
	T[] generateArrayFromPool(int arraySize, int poolSize);

}
