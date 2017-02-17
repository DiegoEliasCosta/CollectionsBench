package de.heidelberg.pvs.container_bench.fastutils.sets_sorted;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import it.unimi.dsi.fastutil.objects.ObjectRBTreeSet;

public class FastUtils_String_RBTreeSet_Test extends AbstractJDKSetTest<String> {

	@Override
	protected Set<String> getNewSet(int size) {
		return new ObjectRBTreeSet<>();
	}

	@Override
	protected Set<String> copySet(Set<String> fullSet2) {
		return new ObjectRBTreeSet<>(fullSet2);
	}

}
