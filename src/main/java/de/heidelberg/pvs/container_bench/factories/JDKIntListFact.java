package de.heidelberg.pvs.container_bench.factories;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;


public enum JDKIntListFact {
	
	// Object 
	JDK_ARRAY(java.util.ArrayList::new), //

	JDK_LINKED(java.util.LinkedList::new), //

    JDK_VECTOR(java.util.Vector::new), //
	
	FASTUTIL_O_ARRAY(it.unimi.dsi.fastutil.objects.ObjectArrayList::new), //
	
	ECLIPSE_O_ARRAY(org.eclipse.collections.impl.list.mutable.FastList::new), //
	
	// Primitive
	AGRONA_I_ARRAY(org.agrona.collections.IntArrayList::new),
	;

	public final Supplier<List<Integer>> maker;

	private JDKIntListFact(Supplier<List<Integer>> maker) {
		this.maker = maker;
	}

}
