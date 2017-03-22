package de.heidelberg.pvs.container_bench.google.maps;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jol.info.GraphLayout;

import com.google.api.client.util.ArrayMap;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;

public class Google_IntegerInteger_ArrayMap_Test extends AbstractJDKMapTest<Integer, Integer> {

	@Override
	protected Map<Integer, Integer> getNewMap() {
		return new ArrayMap<Integer, Integer>();
	}

	@Override
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		// The google ArrayMap does not provide an API for copying
		ArrayMap<Integer,Integer> arrayMap = new ArrayMap<Integer, Integer>();
		arrayMap.putAll(fullMap2);
		return arrayMap;
	}
	
	@Benchmark
	public void reportBoundedCollectionFootprint() throws IOException {
		Map<Integer, Integer> fullCollection;
		fullCollection = ArrayMap.create(size);
		for (int i = 0; i < size; i++) {
			fullCollection.put(keys[i], values[i]);
		}

		// Write to the file
		String footprint = String.format("%s\n%s", fullCollection.getClass().getName(),
				GraphLayout.parseInstance(fullCollection).toFootprint());
		
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(new FileWriter(this.memoryFootprintFile, true));
			printWriter.write(footprint);
		} finally {
			if(printWriter != null) {
				printWriter.close();
			}
		}
	}

}
