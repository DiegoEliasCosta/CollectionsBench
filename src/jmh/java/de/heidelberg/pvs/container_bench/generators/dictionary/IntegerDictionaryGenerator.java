package de.heidelberg.pvs.container_bench.generators.dictionary;

import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.math3.random.Well44497b;

import de.heidelberg.pvs.container_bench.generators.IntElementGenerator;
import de.heidelberg.pvs.container_bench.generators.Wordlist;

public class IntegerDictionaryGenerator implements IntElementGenerator{

	int[] words;

	protected Well44497b randomGenerator;
	
	public void init(int size, int seed) throws IOException {
		
		words = Wordlist.loadInts(size, seed, 1);
		randomGenerator = new Well44497b(seed);
		
	}

	@Override
	public int generateIndex(int range) {
		return randomGenerator.nextInt(range);
	}

	@Override
	public int[] generateIntArray(int arraySize) {
		return Arrays.copyOfRange(words, 0, arraySize);
	}

}
