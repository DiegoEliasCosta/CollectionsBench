package container.benchmarks.intsingleoperations.maps;

import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.openjdk.jmh.annotations.Param;

import container.factories.EclipseMap2IntFact;

public class EclipseMap2IntBench extends AbstractMap2IntBench {
	@Param
	EclipseMap2IntFact impl;

	MutableObjectIntMap<Object> fullMap;

	@Override
	public void testSetup() {
		fullMap = impl.maker.get();
		for (int i = 0; i < values.length; i++) {
			fullMap.put(keys[i], values[i]);
		}
	}

	@Override
	protected void populateBench() {
		MutableObjectIntMap<Object> newMap = impl.maker.get();
		for (int i = 0; i < values.length; i++) {
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
		MutableObjectIntMap<Object> newMap = impl.maker.get();
		newMap.putAll(fullMap);
		blackhole.consume(newMap);
	}

	@Override
	protected void iterateKeyBench() {
		fullMap.forEachKey(blackhole::consume);
	}

	@Override
	protected void iterateKeyValueBench() {
		fullMap.forEachKeyValue((each, parameter) -> {
			blackhole.consume(each);
			blackhole.consume(parameter);
		});
	}
}
