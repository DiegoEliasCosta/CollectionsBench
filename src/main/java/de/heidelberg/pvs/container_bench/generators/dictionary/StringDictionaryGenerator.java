package de.heidelberg.pvs.container_bench.generators.dictionary;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.math3.random.Well44497b;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;

import de.heidelberg.pvs.container_bench.generators.ElementGenerator;
import de.heidelberg.pvs.container_bench.wordlist.Wordlist;

public class StringDictionaryGenerator implements ElementGenerator<String> {
	
	protected List<String> words;
	protected Set<String> uniqueWords;
	
	protected Well44497b generator;

	protected int seed; 
	
	@Override
	public void init(int size, int seed) throws IOException {
		this.seed = seed;
		generator = new Well44497b(seed);
		// Reading it all might be a bit too expensive (I will check this out)
		// We might have to set a limit here
		words = Wordlist.loadWords(Wordlist.READ_ALL, seed);
		uniqueWords = new UnifiedSet<>(words);
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
		
		// Create a pool to draw from
		List<String> pool = uniqueWords.stream().limit(poolSize).collect(Collectors.toList());
		
		String[] array = new String[arraySize];
		for (int i = 0; i < arraySize; i++) {
			int idx = generator.nextInt(poolSize);
			// Draw from the pool
			array[i] = pool.get(idx);
		} 
		
		return array;
		
	}

}
