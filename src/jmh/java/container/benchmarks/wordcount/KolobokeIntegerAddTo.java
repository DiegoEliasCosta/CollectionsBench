package container.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import container.factories.KolobokeMap2IntFact;
import net.openhft.koloboke.collect.map.hash.HashObjIntMap;

public class KolobokeIntegerAddTo extends AbstractWordcountBenchmark<HashObjIntMap<Object>> {
	@Param
	public KolobokeMap2IntFact impl;

	@Override
	protected HashObjIntMap<Object> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected void count(HashObjIntMap<Object> map, String object) {
		map.addValue(object, 1);
	}

	@Override
	protected long size(HashObjIntMap<Object> map) {
		return map.size();
	}
}
