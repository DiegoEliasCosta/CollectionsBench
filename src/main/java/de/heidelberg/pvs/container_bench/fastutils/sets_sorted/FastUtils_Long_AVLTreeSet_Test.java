package de.heidelberg.pvs.container_bench.fastutils.sets_sorted;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetBench;
import it.unimi.dsi.fastutil.objects.ObjectAVLTreeSet;
import it.unimi.dsi.fastutil.objects.ObjectRBTreeSet;

public class FastUtils_Long_AVLTreeSet_Test extends AbstractJDKSetBench<Long> {

	@Override
	protected Set<Long> getNewSet() {
		return new ObjectAVLTreeSet<>();
	}

	@Override
	protected Set<Long> copySet(Set<Long> fullSet2) {
		return new ObjectRBTreeSet<>(fullSet2);
	}

}
