package de.heidelberg.pvs.container_bench.factories;

import java.util.List;
import java.util.function.Supplier;

/**
 * Factory for JDK List implementations 
 * 
 * @author diego.costa
 *
 */
public enum JDKListFact {
	
	JDK_ARRAY(java.util.ArrayList::new), //
	JDK_LINKED(java.util.LinkedList::new), //
    JDK_VECTOR(java.util.Vector::new), //
	
	FASTUTIL_O_ARRAY(it.unimi.dsi.fastutil.objects.ObjectArrayList::new), //
	
	ECLIPSE_O_ARRAY(org.eclipse.collections.impl.list.mutable.FastList::new), //
	
	;

	public final Supplier<List<Object>> maker;

	private JDKListFact(Supplier<List<Object>> maker) {
		this.maker = maker;
	}

}
