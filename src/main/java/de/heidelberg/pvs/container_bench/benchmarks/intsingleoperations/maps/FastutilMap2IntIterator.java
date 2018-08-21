package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.maps;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.FastutilMap2IntFact;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;

public class FastutilMap2IntIterator extends AbstractMap2IntBenchmark {
	@Param
	FastutilMap2IntFact impl;

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
		ObjectIterator<Object> keyIter = fullMap.keySet().iterator();
		while (keyIter.hasNext()) {
			failIfInterrupted();
			blackhole.consume(keyIter.next());
		}
	}

	@Override
	protected void iterateKeyValueBench() {
		ObjectIterator<Object2IntMap.Entry<Object>> iter = fullMap.object2IntEntrySet().iterator();
		while (iter.hasNext()) {
			failIfInterrupted();
			Object2IntMap.Entry<Object> ent = iter.next();
			blackhole.consume(ent.getKey());
			blackhole.consume(ent.getIntValue());
		}
	}
}
