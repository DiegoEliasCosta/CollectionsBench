package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.maps;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.FastutilFastMap2IntFact;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;

public class FastutilHashMap2IntFastIterator extends AbstractMap2IntBenchmark {
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
		ObjectIterator<Object> iter = fullMap.keySet().iterator();
		while (iter.hasNext()) {
			failIfInterrupted();
			blackhole.consume(iter.next());
		}
	}

	@Override
	protected void iterateKeyValueBench() {
		ObjectIterator<Object2IntMap.Entry<Object>> iter = impl.fastEntrySet.apply(fullMap).fastIterator();
		while (iter.hasNext()) {
			failIfInterrupted();
			Object2IntMap.Entry<Object> ent = iter.next();
			blackhole.consume(ent.getKey());
			blackhole.consume(ent.getIntValue());
		}
	}
}
