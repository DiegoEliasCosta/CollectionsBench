package container.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.ObjectIntMap;

import container.factories.HPPCMap2IntFact;

/**
 * Adapter using the HPPC primitive map
 * 
 * @author Erich Schubert
 */
public class HPPCIntegerAddTo extends AbstractWordcountBenchmark<ObjectIntMap<Object>> {
	@Param
	public HPPCMap2IntFact impl;

	@Override
	protected ObjectIntMap<Object> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected void count(ObjectIntMap<Object> map, String object) {
		map.addTo(object, 1);
	}
}