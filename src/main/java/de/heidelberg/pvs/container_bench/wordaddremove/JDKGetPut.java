package de.heidelberg.pvs.container_bench.wordaddremove;

import java.util.Set;
import java.util.function.Supplier;

import org.openjdk.jmh.annotations.Param;

public class JDKGetPut extends AbstractWordAddRemoveBenchmark<Set<String>> {
	@Param
	public ImplEnum impl;
	
	private static final net.openhft.koloboke.collect.set.hash.HashObjSetFactory<Object> KOLOBOKEQ = new net.openhft.koloboke.collect.impl.hash.QHashObjSetFactoryImpl<>();

	public static enum ImplEnum {
		JDK_HASH(java.util.HashSet::new), //
		JDK_LINKEDHASH(java.util.LinkedHashSet::new), //
		JDK_TREE(java.util.TreeSet::new), //
		FASTUTIL_HASH(it.unimi.dsi.fastutil.objects.ObjectOpenHashSet::new), //
		FASTUTIL_AVL(it.unimi.dsi.fastutil.objects.ObjectAVLTreeSet::new), //
		FASTUTIL_RB(it.unimi.dsi.fastutil.objects.ObjectRBTreeSet::new), //
		TROVE_HASH(gnu.trove.set.hash.THashSet::new), //
		KOLOBOKE_HASH(net.openhft.koloboke.collect.set.hash.HashObjSets::newMutableSet), //
		KOLOBOKE_QHASH(() -> KOLOBOKEQ.newMutableSet()), //
		ECLIPSE_HASH(org.eclipse.collections.impl.set.mutable.UnifiedSet::new), //
		ECLIPSE_TREE(org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet::new), //
		APACHE_HASH(() -> org.apache.commons.collections4.set.MapBackedSet.mapBackedSet(//
				new org.apache.commons.collections4.map.HashedMap<String, String>())), //
		APACHE_LINKEDHASH(org.apache.commons.collections4.set.ListOrderedSet::new), //
		AGRONA_HASH(org.agrona.collections.ObjectHashSet::new), //
		JAVOLUTION_HASH(javolution.util.FastSet::new), //
		JAVOLUTION_SORTED(javolution.util.FastSortedSet::new), //
		MAHOUT_HASH(org.apache.mahout.math.set.OpenHashSet::new), //
		// These will be very slow:
		FASTUTIL_ARRAY(it.unimi.dsi.fastutil.objects.ObjectArraySet::new), //
		CORENLP_ARRAY(edu.stanford.nlp.util.ArraySet::new); //
		;

		public final Supplier<Set<String>> maker;

		private ImplEnum(Supplier<Set<String>> maker) {
			this.maker = maker;
		}
	}

	@Override
	protected Set<String> makeSet() {
		return impl.maker.get();
	}

	@Override
	protected int size(Set<String> set) {
		return set.size();
	}

	@Override
	protected void add(Set<String> map, String object) {
		map.add(object);
	}

	@Override
	protected void remove(Set<String> map, String object) {
		map.remove(object);
	}
}
