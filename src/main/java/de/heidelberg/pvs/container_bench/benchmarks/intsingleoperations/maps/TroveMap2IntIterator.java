package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.maps;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.TroveMap2IntFact;
import gnu.trove.iterator.TObjectIntIterator;
import gnu.trove.map.TObjectIntMap;

public class TroveMap2IntIterator extends AbstractMap2IntBenchmark {
	@Param
	TroveMap2IntFact impl;

	TObjectIntMap<Object> fullMap;

	@Override
	public void testSetup() {
		fullMap = impl.maker.get();
		for (int i = 0; i < keys.length && failIfInterrupted(); i++) {
			fullMap.put(keys[i], values[i]);
		}
	}

	@Override
	protected void populateBench() {
		TObjectIntMap<Object> newMap = impl.maker.get();
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
		TObjectIntMap<Object> newMap = impl.maker.get();
		newMap.putAll(fullMap);
		blackhole.consume(newMap);
	}

	@Override
	protected void iterateKeyBench() {
		for (Object key : fullMap.keySet()) {
			failIfInterrupted();
			blackhole.consume(key);
		}
	}

	@Override
	protected void iterateKeyValueBench() {
		for (TObjectIntIterator<Object> iter = fullMap.iterator(); iter.hasNext(); iter.advance()) {
			failIfInterrupted();
			blackhole.consume(iter.key());
			blackhole.consume(iter.value());
		}
	}
}
