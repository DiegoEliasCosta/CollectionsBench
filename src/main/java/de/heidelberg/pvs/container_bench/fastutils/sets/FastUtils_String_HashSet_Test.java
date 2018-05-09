package de.heidelberg.pvs.container_bench.fastutils.sets;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetBench;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;

public class FastUtils_String_HashSet_Test extends AbstractJDKSetBench<String> {

	@Override
	protected Set<String> getNewSet() {
		return new ObjectOpenHashSet<>();
	}

	@Override
	protected Set<String> copySet(Set<String> fullSet2) {
		return new ObjectOpenHashSet<>(fullSet2);
	}

}
