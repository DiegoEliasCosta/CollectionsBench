package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Function;
import java.util.function.Supplier;

import com.carrotsearch.hppc.ObjectArrayList;
import com.carrotsearch.hppc.ObjectIndexedContainer;

public enum HPPCListFact {

	HPPC_ARRAY(ObjectArrayList<Object>::new, ObjectArrayList<Object>::new); //

	public final Supplier<ObjectArrayList<Object>> maker;
	public final Function<ObjectIndexedContainer<Object>, ObjectIndexedContainer<Object>> copyMaker;

	private HPPCListFact(Supplier<ObjectArrayList<Object>> maker,
			Function<ObjectIndexedContainer<Object>, ObjectIndexedContainer<Object>> copyMaker) {
		this.maker = maker;
		this.copyMaker = copyMaker;
	}

}
