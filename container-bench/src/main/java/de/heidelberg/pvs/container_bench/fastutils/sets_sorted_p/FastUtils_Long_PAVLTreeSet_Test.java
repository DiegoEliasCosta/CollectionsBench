package de.heidelberg.pvs.container_bench.fastutils.sets_sorted_p;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import it.unimi.dsi.fastutil.longs.LongAVLTreeSet;

public class FastUtils_Long_PAVLTreeSet_Test extends AbstractJDKSetTest<Long> {

	@Override
	protected Set<Long> getNewSet(int size) {
		return new LongAVLTreeSet();
	}

	@Override
	protected Set<Long> copySet(Set<Long> fullSet2) {
		return new LongAVLTreeSet(fullSet2);
	}

}
