package de.heidelberg.pvs.container_bench.wordcount;

import java.util.function.Supplier;

import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.ObjectObjectHashMap;
import com.carrotsearch.hppc.ObjectObjectMap;
import com.carrotsearch.hppc.ObjectObjectScatterMap;

/**
 * Adapter using the HPPC equivalents of the JCF API
 * 
 * @author Erich Schubert
 */
public class HPPCGetPut extends AbstractWordcountBenchmark<ObjectObjectMap<Object, Integer>> {
	@Param
	public ImplEnum impl;

	public static enum ImplEnum {
		HPPC_O2O_HASH(ObjectObjectHashMap::new), //
		HPPC_O2O_SCATTER(ObjectObjectScatterMap::new), //
		;

		public final Supplier<ObjectObjectMap<Object, Integer>> maker;

		private ImplEnum(Supplier<ObjectObjectMap<Object, Integer>> maker) {
			this.maker = maker;
		}
	}

	@Override
	protected ObjectObjectMap<Object, Integer> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected int size(ObjectObjectMap<Object, Integer> map) {
		return map.size();
	}

	@Override
	protected void count(ObjectObjectMap<Object, Integer> map, Object object) {
		Integer old = map.get(object);
		map.put(object, old != null ? old + 1 : 1);
	}
}