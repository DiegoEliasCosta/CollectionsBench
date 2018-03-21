package de.heidelberg.pvs.container_bench.agrona.sets;

import java.util.Set;

import org.agrona.collections.ObjectHashSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

/**
 * Test for new ObjectHashSet<Integer> as Set<Integer>.
 * 
 * Generated from TemplateSetTest
 */
public class Agrona_Integer_HashSet_Test extends AbstractJDKSetTest<Integer> {
	@Override
	protected Set<Integer> getNewSet() {
		return new ObjectHashSet<Integer>();
	}

	@Override
	protected Set<Integer> copySet(Set<Integer> orig) {
		Set<Integer> s = new ObjectHashSet<>();
		s.addAll(orig);
		return s;
	}
}