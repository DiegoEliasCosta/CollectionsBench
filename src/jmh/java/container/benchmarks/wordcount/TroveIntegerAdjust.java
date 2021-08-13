package container.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import container.factories.TroveMap2IntFact;
import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.hash.TObjectIntHashMap;

public class TroveIntegerAdjust extends AbstractWordcountBenchmark<TObjectIntMap<Object>> {
	@Param
	public TroveMap2IntFact impl;

	@Override
	protected TObjectIntMap<Object> makeMap() {
		return new TObjectIntHashMap<Object>();
	}

	@Override
	protected void count(TObjectIntMap<Object> map, String object) {
		map.adjustOrPutValue(object, 1, 1);
	}
}
