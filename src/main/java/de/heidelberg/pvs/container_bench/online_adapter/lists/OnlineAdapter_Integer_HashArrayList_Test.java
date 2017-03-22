package de.heidelberg.pvs.container_bench.online_adapter.lists;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jol.info.GraphLayout;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import de.heidelberg.pvs.diego.collections_online_adapter.custom.HashArrayList;

public class OnlineAdapter_Integer_HashArrayList_Test extends AbstractJDKListTest<Integer> {

	@Override
	protected List<Integer> getNewList() {
		return new HashArrayList<>();
	}

	@Override
	protected List<Integer> copyList(List<Integer> fullList2) {
		return new HashArrayList<>(fullList2);
	}
	
	@Benchmark
	public void reportBoundedCollectionFootprint() throws IOException {
		List<Integer> fullCollection;
		fullCollection = new HashArrayList<>(size);
		
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
