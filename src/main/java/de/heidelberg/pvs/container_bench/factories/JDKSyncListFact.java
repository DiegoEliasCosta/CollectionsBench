package de.heidelberg.pvs.container_bench.factories;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public enum JDKSyncListFact {
	
	JDK_SYNCHRONIZEDLIST(() -> Collections.synchronizedList(new java.util.ArrayList<>())), //
	JDK_COPYONWRITEARRAYLIST(java.util.concurrent.CopyOnWriteArrayList::new), //
	
	ECLIPSE_O2O_SYNCHRONIZED(() -> org.eclipse.collections.impl.list.mutable.SynchronizedMutableList.of(
			new org.eclipse.collections.impl.list.mutable.FastList<>())), //
	
	FASTUTIL_O2O_SYNCHRONIZED(() -> it.unimi.dsi.fastutil.objects.ObjectLists
			.synchronize(new it.unimi.dsi.fastutil.objects.ObjectArrayList<>())), //

	GUAVA_CONCURRENTHASHSET(com.google.common.collect.Lists::newCopyOnWriteArrayList), //
	
	;

	public final Supplier<List<Object>> maker;

	private JDKSyncListFact(Supplier<List<Object>> maker) {
			this.maker = maker;
	}

	
}
