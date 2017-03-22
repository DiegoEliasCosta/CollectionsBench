package de.heidelberg.pvs.container_bench.gscollections.lists;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jol.info.GraphLayout;

import com.gs.collections.impl.list.mutable.FastList;
import com.gs.collections.impl.set.mutable.UnifiedSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;

public class GSCollections_Integer_FastList_Test extends AbstractJDKListTest<Integer>{

	@Override
	protected List<Integer> getNewList() {
		return new FastList<Integer>();
	}

	@Override
	protected List<Integer> copyList(List<Integer> fullList2) {
		return new FastList<Integer>(fullList2);
	}
	
	@Benchmark
	public void reportBoundedCollectionFootprint() throws IOException {
		List<Integer> fullCollection;
		fullCollection = new FastList<>(size);
		
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
