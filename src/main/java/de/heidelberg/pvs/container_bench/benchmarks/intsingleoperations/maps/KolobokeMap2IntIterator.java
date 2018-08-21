package de.heidelberg.pvs.container_bench.benchmarks.intsingleoperations.maps;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.KolobokeMap2IntFact;
import net.openhft.koloboke.collect.ObjCursor;
import net.openhft.koloboke.collect.map.ObjIntCursor;
import net.openhft.koloboke.collect.map.hash.HashObjIntMap;

public class KolobokeMap2IntIterator extends AbstractMap2IntBenchmark {
	@Param
	KolobokeMap2IntFact impl;

	HashObjIntMap<Object> fullMap;

	@Override
	public void testSetup() {
		fullMap = impl.maker.get();
		for (int i = 0; i < keys.length && failIfInterrupted(); i++) {
			fullMap.put(keys[i], values[i]);
		}
	}

	@Override
	protected void populateBench() {
		HashObjIntMap<Object> newMap = impl.maker.get();
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
		HashObjIntMap<Object> newMap = impl.maker.get();
		newMap.putAll(fullMap);
		blackhole.consume(newMap);
	}

	@Override
	protected void iterateKeyBench() {
		ObjCursor<Object> iter = fullMap.keySet().cursor();
		while (iter.moveNext() && failIfInterrupted()) {
			blackhole.consume(iter.elem());
		}
	}

	@Override
	protected void iterateKeyValueBench() {
		ObjIntCursor<Object> iter = fullMap.cursor();
		while (iter.moveNext() && failIfInterrupted()) {
			blackhole.consume(iter.key());
			blackhole.consume(iter.value());
		}
	}
}
