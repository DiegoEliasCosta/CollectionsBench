package de.heidelberg.pvs.container_bench.agrona.sets;

import java.util.Set;

import org.agrona.collections.ObjectHashSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetBench;

/**
 * Test for new ObjectHashSet<Long> as Set<Long>.
 * 
 * Generated from TemplateSetTest
 */
public class Agrona_Long_HashSet_Test extends AbstractJDKSetBench<Long> {
	@Override
	protected Set<Long> getNewSet() {
		return new ObjectHashSet<Long>();
	}

	@Override
	protected Set<Long> copySet(Set<Long> orig) {
		Set<Long> s = new ObjectHashSet<>();
		s.addAll(orig);
		return s;
	}
}