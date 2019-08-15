package de.heidelberg.pvs.container_bench.factories;

import java.util.Set;
import java.util.function.Supplier;

public enum JDKSetFact {
	
	JDK_HASH(java.util.HashSet::new), //
	JDK_LINKEDHASH(java.util.LinkedHashSet::new), //
	JDK_TREE(java.util.TreeSet::new), //

	KOLOBOKE_HASH(com.koloboke.collect.set.hash.HashObjSets::newMutableSet), //
	KOLOBOKE_QHASH(KolobokeQHash.ObjSets::newMutableSet), //

	FASTUTIL_HASH(it.unimi.dsi.fastutil.objects.ObjectOpenHashSet::new), //
	FASTUTIL_LINKEDHASH(it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet::new), //
	FASTUTIL_AVL(it.unimi.dsi.fastutil.objects.ObjectAVLTreeSet::new), //
	FASTUTIL_RB(it.unimi.dsi.fastutil.objects.ObjectRBTreeSet::new), //
	FASTUTIL_ARRAY(it.unimi.dsi.fastutil.objects.ObjectArraySet::new), //

	TROVE_HASH(gnu.trove.set.hash.THashSet::new), //

	ECLIPSE_HASH(org.eclipse.collections.impl.set.mutable.UnifiedSet::new), //
	ECLIPSE_TREE(org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet::new), //

	APACHE_HASH(() -> org.apache.commons.collections4.set.MapBackedSet.mapBackedSet(//
			new org.apache.commons.collections4.map.HashedMap<>())), //
	APACHE_LINKEDHASH(org.apache.commons.collections4.set.ListOrderedSet::new), //
	MAHOUT_HASH(org.apache.mahout.math.set.OpenHashSet::new), //

	JAVOLUTION_HASH(javolution.util.FastSet::new), //
	JAVOLUTION_SORTED(javolution.util.FastSortedSet::new), //

	AGRONA_HASH(org.agrona.collections.ObjectHashSet::new), //

	CORENLP_ARRAY(edu.stanford.nlp.util.ArraySet::new); //
	;

	public Supplier<Set<?>> maker;

	private JDKSetFact(Supplier<Set<?>> maker) {
		this.maker = maker;
	}
}