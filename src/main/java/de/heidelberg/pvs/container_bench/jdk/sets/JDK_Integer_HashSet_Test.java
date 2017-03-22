package de.heidelberg.pvs.container_bench.jdk.sets;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jol.info.GraphLayout;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import net.openhft.koloboke.collect.set.hash.HashObjSets;

public class JDK_Integer_HashSet_Test extends AbstractJDKSetTest<Integer> {


	@Override
	protected Set<Integer> getNewSet() {
		return new HashSet<Integer>();
	}

	@Override
	protected Set<Integer> copySet(Set<Integer> fullSet2) {
		return new HashSet<Integer>(fullSet2);
	}

	@Benchmark
	public void reportBoundedCollectionFootprint() throws IOException {
		Set<Integer> fullCollection;
		fullCollection = new HashSet<>(size);
		
		for (int i = 0; i < size; i++) {
			fullCollection.add(values[i]);
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