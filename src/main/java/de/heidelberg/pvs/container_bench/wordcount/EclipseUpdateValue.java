package de.heidelberg.pvs.container_bench.wordcount;

import java.util.function.Supplier;

import org.eclipse.collections.api.map.MutableMapIterable;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;
import org.openjdk.jmh.annotations.Param;

public class EclipseUpdateValue extends AbstractWordcountBenchmark<MutableMapIterable<Object, Integer>> {
	@Param
	public ImplEnum impl;

	public static enum ImplEnum {
		ECLIPSE_O2O_HASH(UnifiedMap::new), //
		ECLIPSE_O2O_TREE(TreeSortedMap::new), //
		;

		public final Supplier<MutableMapIterable<Object, Integer>> maker;

		private ImplEnum(Supplier<MutableMapIterable<Object, Integer>> maker) {
			this.maker = maker;
		}
	}

	@Override
	protected MutableMapIterable<Object, Integer> makeMap() {
		return impl.maker.get();
	}

	@Override
	protected int size(MutableMapIterable<Object, Integer> map) {
		return map.size();
	}

	@Override
	protected void count(MutableMapIterable<Object, Integer> map, Object object) {
		map.updateValue(object, () -> 0, x -> x + 1);
	}
}
