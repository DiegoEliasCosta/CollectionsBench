package de.heidelberg.pvs.container_bench.generators.dictionary;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.math3.random.Well44497b;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;

import de.heidelberg.pvs.container_bench.generators.ElementGenerator;
import de.heidelberg.pvs.container_bench.generators.Wordlist;

public class StringDictionaryGenerator implements ElementGenerator<String> {
	
	protected List<String> words;
	
	protected Well44497b generator;

	protected int seed; 
	protected int size;
	
	@Override
	public void init(int size, int seed) throws IOException {
		this.seed = seed;
		this.size = size;
		
		generator = new Well44497b(seed);
		// Read all -> might be too expensive
		words = Wordlist.loadWords(size, seed);
	}

	@Override
	public int generateIndex(int range) {
		return generator.nextInt(range);
	}
	
	@Override
	public String[] generateArray(int arraySize) {
		String[] array = new String[arraySize];
		return words.subList(0, arraySize).toArray(array);
	}

	@Override
	public String[] generateArrayFromPool(int arraySize, int poolSize) {
		
		if(poolSize > this.size << 1) {
			throw new IllegalArgumentException("Poolsize should be at most twice the size of the array");
		}
		
		// Create a pool to draw from
		List<String> pool = words.stream().limit(poolSize).collect(Collectors.toList());
		
		String[] array = new String[arraySize];
		for (int i = 0; i < arraySize; i++) {
			int idx = generator.nextInt(poolSize);
			// Draw from the pool
			array[i] = pool.get(idx);
		} 
		
		return array;
		
	}

}
