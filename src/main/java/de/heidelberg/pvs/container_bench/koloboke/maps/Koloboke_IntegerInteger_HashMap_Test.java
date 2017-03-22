package de.heidelberg.pvs.container_bench.koloboke.maps;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jol.info.GraphLayout;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;
import net.openhft.koloboke.collect.map.hash.HashObjObjMaps;

public class Koloboke_IntegerInteger_HashMap_Test extends AbstractJDKMapTest<Integer, Integer> {

	@Override
	protected Map<Integer, Integer> getNewMap() {
		return HashObjObjMaps.newMutableMap();
	}

	@Override
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		return HashObjObjMaps.newMutableMap(fullMap2);
	}
	
	@Benchmark
	public void reportBoundedCollectionFootprint() throws IOException {
		Map<Integer, Integer> fullCollection;
		fullCollection = HashObjObjMaps.newMutableMap(size);
		
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
