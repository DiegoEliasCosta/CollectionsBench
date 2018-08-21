package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.maps;

import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.ObjectIntMap;
import com.carrotsearch.hppc.cursors.ObjectIntCursor;

import de.heidelberg.pvs.container_bench.factories.HPPCMap2IntFact;

public class HPPCMap2IntIterator extends AbstractMap2IntBenchmark {
	@Param
	HPPCMap2IntFact impl;

	ObjectIntMap<Object> fullMap;

	@Override
	public void testSetup() {
		fullMap = impl.maker.get();
		for (int i = 0; i < keys.length && failIfInterrupted(); i++) {
			fullMap.put(keys[i], values[i]);
		}
	}

	@Override
	protected void populateBench() {
		ObjectIntMap<Object> newMap = impl.maker.get();
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
		ObjectIntMap<Object> newMap = impl.maker.get();
		newMap.putAll(fullMap);
		blackhole.consume(newMap);
	}

	@Override
	protected void iterateKeyBench() {
		for (Object key : fullMap.keys()) {
			failIfInterrupted();
			blackhole.consume(key);
		}
	}

	@Override
	protected void iterateKeyValueBench() {
		for (ObjectIntCursor<Object> ent : fullMap) {
			failIfInterrupted();
			blackhole.consume(ent.key);
			blackhole.consume(ent.value);
		}
	}
}
