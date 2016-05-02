package de.heidelberg.pvs.container_bench.fastutils.sets_p;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;



public class FastUtils_Integer_PHashSet_Test extends AbstractJDKSetTest<Integer> {

	@Override
	protected Set<Integer> getNewSet(int size) {
		return new IntOpenHashSet();
	}

	@Override
	protected Set<Integer> copySet(Set<Integer> fullSet2) {
		return new IntOpenHashSet(fullSet2);
	}

}
