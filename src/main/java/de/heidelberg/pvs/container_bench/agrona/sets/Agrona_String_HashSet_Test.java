package de.heidelberg.pvs.container_bench.agrona.sets;

import java.util.Set;

import org.agrona.collections.ObjectHashSet;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;

/**
 * Test for new ObjectHashSet<String> as Set<String>.
 * 
 * Generated from TemplateSetTest
 */
public class Agrona_String_HashSet_Test extends AbstractJDKSetTest<String> {
	@Override
	protected Set<String> getNewSet() {
		return new ObjectHashSet<String>();
	}

	@Override
	protected Set<String> copySet(Set<String> orig) {
		Set<String> s = new ObjectHashSet<>();
		s.addAll(orig);
		return s;
	}
}