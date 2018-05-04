package de.heidelberg.pvs.container_bench.wordlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

import org.openjdk.jmh.infra.Blackhole;

public class Wordlist {
	/** File name of our input data. */
	public static final String FILENAME = "enwiki-100m.txt.gz";

	public static List<String> loadWords(Blackhole b, int size, int seed) throws IOException {
		// Load the Wikipedia word data.
		try (InputStream is = ClassLoader.getSystemResourceAsStream(FILENAME);
				InputStream gi = new GZIPInputStream(is);
				Reader r = new InputStreamReader(gi);
				BufferedReader reader = new BufferedReader(r)) {
			final int stop = seed == -1 ? size : (size << 1);
			List<String> words = new ArrayList<>(stop);
			String line;
			Matcher m = Pattern.compile("[\\w–-]+", Pattern.UNICODE_CHARACTER_CLASS).matcher("");
			while ((line = reader.readLine()) != null && words.size() < stop) {
				m.reset(line);
				while (m.find()) {
					String word = m.group();
					b.consume(word.hashCode()); // Precompute hashcode
					words.add(word);
				}
			}
			if (seed != -1) {
				Collections.shuffle(words, new Random(seed));
			}
			words.subList(size, words.size()).clear(); // Truncate
			return words;
		}
	}

}
