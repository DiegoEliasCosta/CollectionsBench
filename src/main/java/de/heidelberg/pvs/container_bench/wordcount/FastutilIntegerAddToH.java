package de.heidelberg.pvs.container_bench.wordcount;

import org.openjdk.jmh.annotations.Param;

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
	@Param({ "FASTUTIL_O2I_HASH" })
	public String impl;

	@Override
	protected Object2IntOpenHashMap<Object> makeMap() {
		return new Object2IntOpenHashMap<Object>();
	}

	@Override
	protected int size(Object2IntOpenHashMap<Object> map) {
		return map.size();
	}

	@Override
	protected void count(Object2IntOpenHashMap<Object> map, Object object) {
		map.addTo(object, 1);
	}
}
