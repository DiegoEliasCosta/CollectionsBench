package de.heidelberg.pvs.container_bench.fastutils.sets_sorted;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import it.unimi.dsi.fastutil.objects.ObjectRBTreeSet;

public class FastUtils_Long_RBTreeSet_Test extends AbstractJDKSetTest<Long> {

	@Override
	protected Set<Long> getNewSet(int size) {
		return new ObjectRBTreeSet<>();
	}

	@Override
	protected Set<Long> copySet(Set<Long> fullSet2) {
		return new ObjectRBTreeSet<>(fullSet2);
	}

}
