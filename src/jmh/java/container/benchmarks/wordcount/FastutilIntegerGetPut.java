package container.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import container.factories.FastutilMap2IntFact;
import it.unimi.dsi.fastutil.objects.Object2IntMap;

public class FastutilIntegerGetPut extends AbstractWordcountBenchmark<Object2IntMap<Object>> {
	@Param
	public FastutilMap2IntFact impl;

	@Override
	protected Object2IntMap<Object> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected void count(Object2IntMap<Object> map, String object) {
		map.put(object, map.getInt(object) + 1);
	}

	@Override
	protected long size(Object2IntMap<Object> map) {
		return map.size();
	}
}
