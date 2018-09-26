package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jol.info.GraphLayout;

import de.heidelberg.pvs.container_bench.factories.FastutilMap2IntFact;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;

/**
 * Class to measure the payload data of the benchmark only.
 *
 * @author Erich Schubert
 */
public class Payload extends AbstractWordcountBenchmark<ObjectOpenHashSet<String>> {
	@Param({ "PAYLOAD" })
	public String impl;

	@Override
	protected ObjectOpenHashSet<String> makeMap() {
		if (!doMemory) {
			throw new IllegalStateException("For memory measurements only!");
		}
		return new ObjectOpenHashSet<>();
	}

	@Override
	protected void count(ObjectOpenHashSet<String> map, String object) {
		map.add(object);
	}

	@Override
	protected int size(ObjectOpenHashSet<String> map) {
		return map.size();
	}

	@Override
	public void measureMemory(ObjectOpenHashSet<String> map, Memory memory) {
		memory.numentries = size(map);
		long total = 0;
		for (String k : map) {
			GraphLayout layout = GraphLayout.parseInstance(k);
			total += layout.totalSize() /* key */ + 4 /* count */;
		}
		memory.totalmemory = total;
	}
}
