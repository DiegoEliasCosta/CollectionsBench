package container.factories;

import java.util.function.Supplier;

import com.carrotsearch.hppc.IntHashSet;
import com.carrotsearch.hppc.IntSet;
import com.carrotsearch.hppc.IntWormSet;


public enum HPPCIntSetFact {
	HPPC_I_HASH(IntHashSet::new), //
	HPPC_I_WORM(IntWormSet::new), //
	;

	public final Supplier<IntSet> maker;
	
	private HPPCIntSetFact(Supplier<IntSet> maker) {
		this.maker = maker;
	}
}