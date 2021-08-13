package container.factories;

import java.util.function.Function;
import java.util.function.Supplier;

import com.carrotsearch.hppc.ObjectHashSet;
import com.carrotsearch.hppc.ObjectSet;
import com.carrotsearch.hppc.ObjectWormSet;

public enum HPPCSetFact {
	HPPC_O_HASH(ObjectHashSet::new, ObjectHashSet::new), //
	HPPC_O_WORM(ObjectWormSet::new, ObjectWormSet::from), //
	;

	public final Supplier<ObjectSet<Object>> maker;
	public final Function<ObjectSet<Object>, ObjectSet<Object>> copyMaker;

	private HPPCSetFact(Supplier<ObjectSet<Object>> maker, 
			Function<ObjectSet<Object>, ObjectSet<Object>> copyMaker) {
		this.maker = maker;
		this.copyMaker = copyMaker;
	}
}