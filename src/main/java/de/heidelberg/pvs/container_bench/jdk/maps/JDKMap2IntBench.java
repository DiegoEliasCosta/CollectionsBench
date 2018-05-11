package de.heidelberg.pvs.container_bench.jdk.maps;

import java.util.Map;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKMapBench;
import de.heidelberg.pvs.container_bench.factories.JDKMap2IntFact;

public class JDKMap2IntBench extends AbstractJDKMapBench<Object, Integer> {

	@Param
	JDKMap2IntFact impl;
	
	@Override
	protected Map<Object, Integer> getNewMap() {
		return impl.maker.get();
	}


}
