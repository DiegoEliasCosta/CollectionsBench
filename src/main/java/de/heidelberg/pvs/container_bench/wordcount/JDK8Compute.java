package de.heidelberg.pvs.container_bench.wordcount;

import java.util.Map;

public class JDK8Compute extends AbstractJDKCompatible {
	@Override
	protected void count(Map<Object, Integer> map, Object object) {
		map.compute(object, (key, value) -> value == null ? 1 : value + 1);
	}
}
