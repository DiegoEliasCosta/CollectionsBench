package de.heidelberg.pvs.container_bench.koloboke.sets;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import net.openhft.koloboke.collect.set.hash.HashObjSets;

public class Koloboke_String_HashSet_Test extends AbstractJDKSetTest<String> {

	@Override
	protected Set<String> getNewSet(int size) {
		return HashObjSets.newMutableSet();
	}

	@Override
	protected Set<String> copySet(Set<String> fullSet2) {
		return HashObjSets.newMutableSet(fullSet2);
	}
	

}
