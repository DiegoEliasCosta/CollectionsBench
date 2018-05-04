package de.heidelberg.pvs.container_bench.wordcount;

import java.util.function.Supplier;

import org.openjdk.jmh.annotations.Param;

import it.unimi.dsi.fastutil.objects.Object2IntAVLTreeMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap;

public class FastutilIntegerGetPut extends AbstractWordcountBenchmark<Object2IntMap<Object>> {
	@Param
	public ImplEnum impl;

	public static enum ImplEnum {
		FASTUTIL_O2I_HASH(Object2IntOpenHashMap::new), //
		FASTUTIL_O2I_AVL(Object2IntAVLTreeMap::new), //
		FASTUTIL_O2I_RB(Object2IntRBTreeMap::new), //
		// FASTUTIL_O2I_ARRAY(Object2IntArrayMap::new), //
		;

		public final Supplier<Object2IntMap<Object>> maker;

		private ImplEnum(Supplier<Object2IntMap<Object>> maker) {
			this.maker = maker;
		}
	}

	@Override
	protected Object2IntMap<Object> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected int size(Object2IntMap<Object> map) {
		return map.size();
	}

	@Override
	protected void count(Object2IntMap<Object> map, String object) {
		map.put(object, map.getInt(object) + 1);
	}
}
