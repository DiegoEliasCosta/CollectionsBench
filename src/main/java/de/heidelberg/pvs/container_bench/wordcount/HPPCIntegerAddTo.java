package de.heidelberg.pvs.container_bench.wordcount;

import java.util.function.Supplier;

import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.ObjectIntHashMap;
import com.carrotsearch.hppc.ObjectIntMap;
import com.carrotsearch.hppc.ObjectIntScatterMap;

/**
 * Adapter using the HPPC primitive map
 * 
 * @author Erich Schubert
 */
public class HPPCIntegerAddTo extends AbstractWordcountBenchmark<ObjectIntMap<Object>> {
	@Param
	public ImplEnum impl;

	public static enum ImplEnum {
		HPPC_O2I_HASH(ObjectIntHashMap::new), //
		HPPC_O2I_SCATTER(ObjectIntScatterMap::new), //
		;

		public final Supplier<ObjectIntMap<Object>> maker;

		private ImplEnum(Supplier<ObjectIntMap<Object>> maker) {
			this.maker = maker;
		}
	}

	@Override
	protected ObjectIntMap<Object> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected int size(ObjectIntMap<Object> map) {
		return map.size();
	}

	@Override
	protected void count(ObjectIntMap<Object> map, String object) {
		map.addTo(object, 1);
	}
}