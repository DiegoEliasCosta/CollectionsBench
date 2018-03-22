package de.heidelberg.pvs.container_bench.wordcount;

import java.util.Map;

public class JDKGetPut extends AbstractJDKCompatible {
	@Override
	protected void count(Map<Object, Integer> map, Object object) {
		Integer old = map.get(object);
		map.put(object, old != null ? old + 1 : 1);
	}
}
