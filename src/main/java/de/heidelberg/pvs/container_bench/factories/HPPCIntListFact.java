package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Function;
import java.util.function.Supplier;

import com.carrotsearch.hppc.IntArrayList;
import com.carrotsearch.hppc.IntIndexedContainer;

public enum HPPCIntListFact {

	HPPC_ARRAY(IntArrayList::new, IntArrayList::new); //

	public final Supplier<IntIndexedContainer> maker;
	public final Function<IntIndexedContainer, IntIndexedContainer> copyMaker;

	private HPPCIntListFact(Supplier<IntIndexedContainer> maker,
			Function<IntIndexedContainer, IntIndexedContainer> copyMaker) {
		this.maker = maker;
		this.copyMaker = copyMaker;
	}

}
