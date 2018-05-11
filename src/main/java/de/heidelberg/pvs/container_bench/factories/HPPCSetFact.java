package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Function;
import java.util.function.Supplier;

import com.carrotsearch.hppc.ObjectHashSet;
import com.carrotsearch.hppc.ObjectScatterSet;
import com.carrotsearch.hppc.ObjectSet;

public enum HPPCSetFact {
	HPPC_O_HASH(ObjectHashSet::new, ObjectHashSet::new), //
	HPPC_O_SCATTER(ObjectScatterSet::new, ObjectScatterSet::from), //
	;

	public final Supplier<ObjectSet<Object>> maker;
	public final Function<ObjectSet<Object>, ObjectSet<Object>> copyMaker;

	private HPPCSetFact(Supplier<ObjectSet<Object>> maker, 
			Function<ObjectSet<Object>, ObjectSet<Object>> copyMaker) {
		this.maker = maker;
		this.copyMaker = copyMaker;
	}
}