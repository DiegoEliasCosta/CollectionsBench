package de.heidelberg.pvs.container_bench.fastutils.sets;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetBench;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;

public class FastUtils_Long_HashSet_Test extends AbstractJDKSetBench<Long> {

	@Override
	protected Set<Long> getNewSet() {
		return new ObjectOpenHashSet<>();
	}

	@Override
	protected Set<Long> copySet(Set<Long> fullSet2) {
		return new ObjectOpenHashSet<>(fullSet2);
	}


}
