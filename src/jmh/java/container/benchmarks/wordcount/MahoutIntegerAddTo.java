package container.benchmarks.wordcount;

import org.apache.mahout.math.map.OpenObjectIntHashMap;
import org.openjdk.jmh.annotations.Param;

import container.factories.MahoutMap2IntFact;

public class MahoutIntegerAddTo extends AbstractWordcountBenchmark<OpenObjectIntHashMap<Object>> {
	@Param
	public MahoutMap2IntFact impl;

	@Override
	protected OpenObjectIntHashMap<Object> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected void count(OpenObjectIntHashMap<Object> map, String object) {
		map.adjustOrPutValue(object, 1, 1);
	}

	@Override
	protected long size(OpenObjectIntHashMap<Object> map) {
		return map.size();
	}
}
