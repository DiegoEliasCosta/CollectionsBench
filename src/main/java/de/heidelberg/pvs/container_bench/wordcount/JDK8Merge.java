package de.heidelberg.pvs.container_bench.wordcount;

import java.util.Map;

public class JDK8Merge extends AbstractJDKCompatible {
	@Override
	protected void count(Map<Object, Integer> map, String object) {
		map.merge(object, 1, (x, y) -> x != null ? x + y : y);
	}
}
