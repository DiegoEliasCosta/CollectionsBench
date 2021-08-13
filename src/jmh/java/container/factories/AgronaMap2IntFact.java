package container.factories;

import java.util.function.Supplier;

import org.agrona.collections.Object2IntHashMap;

public enum AgronaMap2IntFact {
	AGRONA_O2I_HASH;

	public final Supplier<Object2IntHashMap<Object>> maker = () -> new Object2IntHashMap<Object>(0);
}
