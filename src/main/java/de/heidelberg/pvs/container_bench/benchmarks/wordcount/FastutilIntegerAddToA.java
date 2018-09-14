package de.heidelberg.pvs.container_bench.benchmarks.wordcount;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.FastutilMap2IntFact;
import it.unimi.dsi.fastutil.objects.Object2IntAVLTreeMap;

/**
 * Integer-valued better function call for fastutil.
 * 
 * The addTo method exists in the OpenHashMap, RBTree and AVLTree, but not in a
 * shared interface. So we would need three copies of this class. :-(
 * 
 * @author Erich Schubert
 */
public class FastutilIntegerAddToA extends AbstractWordcountBenchmark<Object2IntAVLTreeMap<Object>> {
	@Param({ "FASTUTIL_O2I_AVL" }) // The others do not work!
	public FastutilMap2IntFact impl;

	@Override
	protected Object2IntAVLTreeMap<Object> makeMap() {
		// For other "impl" values, this will fail. That is ok.
		return (Object2IntAVLTreeMap<Object>) impl.maker.get();
	}

	@Override
	protected void count(Object2IntAVLTreeMap<Object> map, String object) {
		map.addTo(object, 1);
	}

	@Override
	protected int size(Object2IntAVLTreeMap<Object> map) {
		return map.size();
	}
}
