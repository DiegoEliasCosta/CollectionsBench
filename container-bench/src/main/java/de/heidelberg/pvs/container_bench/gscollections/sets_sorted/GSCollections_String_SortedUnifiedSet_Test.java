package de.heidelberg.pvs.container_bench.gscollections.sets_sorted;

import java.util.Set;

import com.gs.collections.impl.set.mutable.SetAdapter;
import com.gs.collections.impl.set.mutable.UnifiedSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

public class GSCollections_String_SortedUnifiedSet_Test extends AbstractJDKSetTest<String> {

	@Override
	protected Set<String> getNewSet(int size) {
		return SetAdapter.adapt(new UnifiedSet<String>());
	}

	@Override
	protected Set<String> copySet(Set<String> fullSet2) {
		return SetAdapter.adapt(new UnifiedSet<String>(fullSet2));
	}

}
