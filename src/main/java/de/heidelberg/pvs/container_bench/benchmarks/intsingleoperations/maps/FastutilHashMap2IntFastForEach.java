package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.maps;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.FastutilFastMap2IntFact;
import it.unimi.dsi.fastutil.objects.Object2IntMap;

public class FastutilHashMap2IntFastForEach extends AbstractMap2IntBenchmark {
	@Param
	FastutilFastMap2IntFact impl;

	Object2IntMap<Object> fullMap;

	@Override
	public void testSetup() {
		fullMap = impl.maker.get();
		for (int i = 0; i < keys.length && failIfInterrupted(); i++) {
			fullMap.put(keys[i], values[i]);
		}
	}

	@Override
	protected void populateBench() {
		Object2IntMap<Object> newMap = impl.maker.get();
		for (int i = 0; i < keys.length && failIfInterrupted(); i++) {
			newMap.put(keys[i], values[i]);
		}
		blackhole.consume(newMap);
	}

	@Override
	protected void containsBench() {
		int index = keyGenerator.generateIndex(size);
		fullMap.containsKey(keys[index]);
	}

	@Override
	protected void copyBench() {
		Object2IntMap<Object> newMap = impl.maker.get();
		newMap.putAll(fullMap);
		blackhole.consume(newMap);
	}

	@Override
	protected void iterateKeyBench() {
		fullMap.keySet().forEach(key -> {
			failIfInterrupted();
			blackhole.consume(key);
		});
	}

	@Override
	protected void iterateKeyValueBench() {
		impl.fastEntrySet.apply(fullMap).fastForEach(e -> {
			failIfInterrupted();
			blackhole.consume(e.getKey());
			blackhole.consume(e.getIntValue());
		});
	}
}
