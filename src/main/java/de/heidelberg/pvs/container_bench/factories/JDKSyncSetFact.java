package de.heidelberg.pvs.container_bench.factories;

import java.util.Collections;
import java.util.Set;
import java.util.function.Supplier;

public enum JDKSyncSetFact {

	JDK_CONCURRENTHASHSET(() -> java.util.Collections.newSetFromMap(new java.util.concurrent.ConcurrentHashMap<>())), //
	JDK_CONCURRENTSKIPLIST(java.util.concurrent.ConcurrentSkipListSet::new), //
	JDK_SYNCHRONIZEDSET(() -> Collections.synchronizedSet(new java.util.HashSet<>())), //
	
	ECLIPSE_O2O_SYNCHRONIZEDHASH(() -> org.eclipse.collections.impl.set.mutable.SynchronizedMutableSet.of(
			new org.eclipse.collections.impl.set.mutable.UnifiedSet<>())), //

	FASTUTIL_O2O_SYNCHRONIZED(() -> it.unimi.dsi.fastutil.objects.ObjectSets
			.synchronize(new it.unimi.dsi.fastutil.objects.ObjectOpenHashSet<Object>())), //
	
	GUAVA_CONCURRENTHASHSET(com.google.common.collect.Sets::newConcurrentHashSet), //
	;

	public final Supplier<Set<Object>> maker;

	private JDKSyncSetFact(Supplier<Set<Object>> maker) {
			this.maker = maker;
	}

}
