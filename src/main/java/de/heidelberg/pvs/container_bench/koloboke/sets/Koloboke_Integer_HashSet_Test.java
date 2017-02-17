package de.heidelberg.pvs.container_bench.koloboke.sets;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import net.openhft.koloboke.collect.set.hash.HashObjSets;

public class Koloboke_Integer_HashSet_Test extends AbstractJDKSetTest<Integer> {

	@Override
	protected Set<Integer> getNewSet(int size) {
		return HashObjSets.newMutableSet();
	}

	@Override
	protected Set<Integer> copySet(Set<Integer> fullSet2) {
		return HashObjSets.newMutableSet(fullSet2);
	}


}
