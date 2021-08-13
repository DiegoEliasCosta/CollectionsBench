package container.factories;

import java.util.function.Supplier;

import net.openhft.koloboke.collect.set.IntSet;

public enum KolobokeIntSetFact {
	KOLOBOKE_I_HASH(net.openhft.koloboke.collect.set.hash.HashIntSets::newMutableSet), //
	KOLOBOKE_I_QHASH(KolobokeQHash.IntSets::newMutableSet), //
	;

	public final Supplier<IntSet> maker;

	private KolobokeIntSetFact(Supplier<IntSet> maker) {
		this.maker = maker;
	}
}