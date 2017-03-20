package de.heidelberg.pvs.container_bench.online_adapter.sets;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.diego.collections_online_adapter.custom.ArraySet;

public class OnlineAdapter_Integer_ArraySet_Test extends AbstractJDKSetTest<Integer> {

	@SuppressWarnings("unchecked")
	@Override
	protected Set<Integer> getNewSet() {
		return new ArraySet();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Set<Integer> copySet(Set<Integer> fullSet2) {
		ArraySet arraySet = new ArraySet();
		arraySet.addAll(fullSet2);
		return arraySet;
	}

}
