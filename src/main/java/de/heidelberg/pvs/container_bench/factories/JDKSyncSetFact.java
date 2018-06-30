package de.heidelberg.pvs.container_bench.factories;

import java.util.Set;
import java.util.function.Supplier;

public enum JDKSyncSetFact {

//	JDK_O2O_HASHTABLE(java.util.Hashtable::new), //
//	JDK_O2O_CONCURRENTHASH(java.util.concurrent.ConcurrentHashMap::new), //
//	JDK_O2O_SYNCHRONIZED(() -> Collections.synchronizedMap(new java.util.HashMap<Object, Integer>())), //
//
//	ECLIPSE_O2O_CONCURRENTHASH(org.eclipse.collections.impl.map.mutable.ConcurrentHashMap::new),
//
//	FASTUTIL_O2O_SYNCHRONIZED(() -> it.unimi.dsi.fastutil.objects.Object2ObjectMaps
//			.synchronize(new it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<Object, Integer>())),
//	DIEGO START HERE
//	JDK_CONCURRENTHASHSET(java.util.Collections.newSetFromMap(java.util.concurrent.ConcurrentHashMap::new)),
	
	JDK_CONCURRENTSKIPLIST(java.util.concurrent.ConcurrentSkipListSet::new),
	
	GUAVA_CONCURRENTHASHSET(com.google.common.collect.Sets::newConcurrentHashSet),
	

	

	;

	public final Supplier<Set<Object>> maker;

	private JDKSyncSetFact(Supplier<Set<Object>> maker) {
			this.maker = maker;
	}

}
