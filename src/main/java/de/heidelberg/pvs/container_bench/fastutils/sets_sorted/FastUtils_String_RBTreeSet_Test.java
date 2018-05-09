package de.heidelberg.pvs.container_bench.fastutils.sets_sorted;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetBench;
import it.unimi.dsi.fastutil.objects.ObjectRBTreeSet;

public class FastUtils_String_RBTreeSet_Test extends AbstractJDKSetBench<String> {

	@Override
	protected Set<String> getNewSet() {
		return new ObjectRBTreeSet<>();
	}

	@Override
	protected Set<String> copySet(Set<String> fullSet2) {
		return new ObjectRBTreeSet<>(fullSet2);
	}

}
