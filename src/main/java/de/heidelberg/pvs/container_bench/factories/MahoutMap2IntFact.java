package de.heidelberg.pvs.container_bench.factories;

import java.util.function.Supplier;

import org.apache.mahout.math.map.OpenObjectIntHashMap;

public enum MahoutMap2IntFact {
	MAHOUT_O2I_HASH; //

	public final Supplier<OpenObjectIntHashMap<Object>> maker = OpenObjectIntHashMap::new;
}
