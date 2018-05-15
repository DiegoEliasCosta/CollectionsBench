package de.heidelberg.pvs.container_bench.jdk.sets;

import java.util.Set;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.benchmarks.singleoperations.sets.AbstractJDKSetBench;
import de.heidelberg.pvs.container_bench.factories.JDKSetFact;

public class JDKStrSetBench extends AbstractJDKSetBench<String> {

	@Param
	JDKSetFact impl;
	
	@Override
	protected Set<String> getNewSet() {
		return impl.maker.get();
	}

}
