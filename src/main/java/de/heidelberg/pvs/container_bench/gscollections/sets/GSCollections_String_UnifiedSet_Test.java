package de.heidelberg.pvs.container_bench.gscollections.sets;

import java.util.Set;

import com.gs.collections.impl.set.mutable.UnifiedSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

public class GSCollections_String_UnifiedSet_Test extends AbstractJDKSetTest<String> {

	@Override
	protected Set<String> getNewSet(int size) {
		return new UnifiedSet<String>();
	}

	@Override
	protected Set<String> copySet(Set<String> fullSet2) {
		return new UnifiedSet<String>(fullSet2);
	}

}
