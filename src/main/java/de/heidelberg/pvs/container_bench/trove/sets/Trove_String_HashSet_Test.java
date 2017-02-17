package de.heidelberg.pvs.container_bench.trove.sets;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import gnu.trove.set.hash.THashSet;

public class Trove_String_HashSet_Test extends AbstractJDKSetTest<String> {

	@Override
	protected Set<String> getNewSet(int size) {
		return new THashSet<>();
	}

	@Override
	protected Set<String> copySet(Set<String> fullSet2) {
		return new THashSet<>(fullSet2);
	}

}
