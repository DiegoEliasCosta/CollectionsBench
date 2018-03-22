package de.heidelberg.pvs.container_bench.wordcount;

import org.openjdk.jmh.annotations.Param;

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
	@Param({ "FASTUTIL_O2I_AVL" })
	public String impl;

	@Override
	protected Object2IntAVLTreeMap<Object> makeMap() {
		return new Object2IntAVLTreeMap<Object>();
	}

	@Override
	protected int size(Object2IntAVLTreeMap<Object> map) {
		return map.size();
	}

	@Override
	protected void count(Object2IntAVLTreeMap<Object> map, Object object) {
		map.addTo(object, 1);
	}
}
