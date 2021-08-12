package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;

public enum GuavaMultiSetFact {
	GUAVA_HASH_MULTISET(HashMultiset::create),
	GUAVA_TREE_MULTISET(TreeMultiset::create),
	GUAVA_LINKEDHASH_MULTISET(LinkedHashMultiset::create);
	
	public final Supplier<Multiset<?>> maker;

	private GuavaMultiSetFact(Supplier<Multiset<?>> maker) {
		this.maker = maker;
	}
}
