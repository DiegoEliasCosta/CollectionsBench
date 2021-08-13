package container.factories;

import java.util.function.Supplier;

import com.carrotsearch.hppc.ObjectIntHashMap;
import com.carrotsearch.hppc.ObjectIntMap;
import com.carrotsearch.hppc.ObjectIntWormMap;

public enum HPPCMap2IntFact {
	HPPC_O2I_HASH(ObjectIntHashMap::new), //
	HPPC_O2I_WORM(ObjectIntWormMap::new), //
	;

	public final Supplier<ObjectIntMap<Object>> maker;

	private HPPCMap2IntFact(Supplier<ObjectIntMap<Object>> maker) {
		this.maker = maker;
	}
}