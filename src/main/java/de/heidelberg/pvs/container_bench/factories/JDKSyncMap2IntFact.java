package de.heidelberg.pvs.container_bench.factories;

import java.util.Collections;
import java.util.Map;
import java.util.function.Supplier;

public enum JDKSyncMap2IntFact {

	JDK_O2O_HASHTABLE(java.util.Hashtable::new), //
	JDK_O2O_CONCURRENTHASH(java.util.concurrent.ConcurrentHashMap::new), //
	JDK_O2O_SYNCHRONIZED(() -> Collections.synchronizedMap(new java.util.HashMap<Object, Integer>())), //
	JDK_O2O_CONCURRENTSKIPLIST(java.util.concurrent.ConcurrentSkipListMap::new), //

	ECLIPSE_O2O_CONCURRENTHASH(org.eclipse.collections.impl.map.mutable.ConcurrentHashMap::new), //

	FASTUTIL_O2O_SYNCHRONIZED(() -> it.unimi.dsi.fastutil.objects.Object2ObjectMaps
			.synchronize(new it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap<Object, Integer>())), //
	
	GUAVA_O2O_CONCURRENTMAP(com.google.common.collect.Maps::newConcurrentMap) //
	
	;

	public final Supplier<Map<Object, Integer>> maker;

	private JDKSyncMap2IntFact(Supplier<Map<Object, Integer>> maker) {
		this.maker = maker;
	}
}
