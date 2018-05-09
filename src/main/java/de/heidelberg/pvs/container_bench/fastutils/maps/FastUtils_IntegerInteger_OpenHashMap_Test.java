package de.heidelberg.pvs.container_bench.fastutils.maps;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jol.info.GraphLayout;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapBench;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

public class FastUtils_IntegerInteger_OpenHashMap_Test extends AbstractJDKMapBench<Integer, Integer> {

	@Override
	protected Map<Integer, Integer> getNewMap() {
		return new Object2ObjectOpenHashMap<>();
	}

	@Override
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		return new Object2ObjectOpenHashMap<>(fullMap2);
	}
	
	@Benchmark
	public void reportBoundedCollectionFootprint() throws IOException {
		Map<Integer, Integer> fullCollection;
		fullCollection = new Object2ObjectOpenHashMap<>(size);
		
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
