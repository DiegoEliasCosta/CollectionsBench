package de.heidelberg.pvs.container_bench.factories;

@FunctionalInterface
public interface ObjIntIncrementer<M, K> {
	void addTo(M map, K key, int v);
}
