package de.heidelberg.pvs.container_bench.jdk.maps;

import java.util.LinkedHashMap;
import java.util.Map;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapTest;

public class JDK_IntegerInteger_LinkedHashMap_Test extends AbstractJDKMapTest<Integer, Integer>{

	@Override
	protected Map<Integer, Integer> getNewMap(int size, int range) {
		return new LinkedHashMap<Integer, Integer>();
	}

	@Override
	protected int generateRandomIndex(int size) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected Integer[] generateRandomKeys(int size, int range) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Integer generateRandomKey(int range) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Integer[] generateRandomValues(int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Integer generateRandomValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Map<Integer, Integer> copyMap(Map<Integer, Integer> fullMap2) {
		// TODO Auto-generated method stub
		return null;
	}

}
