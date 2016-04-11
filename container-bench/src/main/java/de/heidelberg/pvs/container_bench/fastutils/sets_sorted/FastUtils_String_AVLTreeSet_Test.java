package de.heidelberg.pvs.container_bench.fastutils.sets_sorted;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;
import de.heidelberg.pvs.container_bench.random.StringRandomGenerator;
import it.unimi.dsi.fastutil.objects.ObjectAVLTreeSet;
import it.unimi.dsi.fastutil.objects.ObjectRBTreeSet;

public class FastUtils_String_AVLTreeSet_Test extends AbstractJDKSetTest<String> {

	@Override
	protected Set<String> getNewSet(int size) {
		return new ObjectAVLTreeSet<>();
	}

	@Override
	protected Set<String> copySet(Set<String> fullSet2) {
		return new ObjectRBTreeSet<>(fullSet2);
	}

	@Override
	protected RandomGenerator<String> instantiateRandomGenerator() {
		return new StringRandomGenerator();
	}

}
