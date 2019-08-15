package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;

public enum GuavaMultiSetFact {
	
	GUAVA_HASH_MULTISET(HashMultiset::create), //
	GUAVA_LINKEDHASH_MULTISET(LinkedHashMultiset::create); //
	
	public final Supplier<Multiset<Object>> maker;

	private GuavaMultiSetFact(Supplier<Multiset<Object>> maker) {
		this.maker = maker;
	}
}
