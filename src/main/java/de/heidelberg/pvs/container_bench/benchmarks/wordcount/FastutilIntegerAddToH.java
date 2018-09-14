package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.FastutilMap2IntFact;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

/**
 * Integer-valued better function call for fastutil.
 * 
 * The addTo method exists in the OpenHashMap, RBTree and AVLTree, but not in a
 * shared interface. So we would need three copies of this class. :-(
 * 
 * @author Erich Schubert
 */
public class FastutilIntegerAddToH extends AbstractWordcountBenchmark<Object2IntOpenHashMap<Object>> {
	@Param({ "FASTUTIL_O2I_HASH" }) // The others do not work!
	public FastutilMap2IntFact impl;

	@Override
	protected Object2IntOpenHashMap<Object> makeMap() {
		// For other "impl" values, this will fail. That is ok.
		return (Object2IntOpenHashMap<Object>) impl.maker.get();
	}

	@Override
	protected void count(Object2IntOpenHashMap<Object> map, String object) {
		map.addTo(object, 1);
	}

	@Override
	protected int size(Object2IntOpenHashMap<Object> map) {
		return map.size();
	}
}
