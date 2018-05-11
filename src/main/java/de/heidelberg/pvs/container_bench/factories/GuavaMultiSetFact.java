package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;


import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public enum GuavaMultiSetFact {
	
	GUAVA_MULTISET(HashMultiset::create);
	
	public final Supplier<Multiset<Object>> maker;

	private GuavaMultiSetFact(Supplier<Multiset<Object>> maker) {
		this.maker = maker;
	}
}
