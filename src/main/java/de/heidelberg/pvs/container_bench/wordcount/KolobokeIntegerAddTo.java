package de.heidelberg.pvs.container_bench.wordcount;

import java.util.function.Supplier;

import org.openjdk.jmh.annotations.Param;

import net.openhft.koloboke.collect.map.hash.HashObjIntMap;

public class KolobokeIntegerAddTo extends AbstractWordcountBenchmark<HashObjIntMap<Object>> {
	@Param
	public ImplEnum impl;

	private static final net.openhft.koloboke.collect.map.hash.HashObjIntMapFactory<Object> KOLOBOKEQ = new net.openhft.koloboke.collect.impl.hash.QHashSeparateKVObjIntMapFactoryImpl<>();

	public static enum ImplEnum {
		KOLOBOKE_O2I_HASH(net.openhft.koloboke.collect.map.hash.HashObjIntMaps::newMutableMap), //
		KOLOBOKE_O2I_QHASH(() -> KOLOBOKEQ.newMutableMap()), //
		;

		public final Supplier<HashObjIntMap<Object>> maker;

		private ImplEnum(Supplier<HashObjIntMap<Object>> maker) {
			this.maker = maker;
		}
	}

	@Override
	protected HashObjIntMap<Object> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected int size(HashObjIntMap<Object> map) {
		return map.size();
	}

	@Override
	protected void count(HashObjIntMap<Object> map, String object) {
		map.addValue(object, 1);
	}
}
