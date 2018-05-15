package de.heidelberg.pvs.container_bench.jdk.sets;

import java.util.Set;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.benchmarks.singleoperations.sets.AbstractJDKSetBench;
import de.heidelberg.pvs.container_bench.factories.JDKIntSetFact;

public class JDKIntSetBench extends AbstractJDKSetBench<Integer> {

	@Param
	JDKIntSetFact impl;
	
	@Override
	protected Set<Integer> getNewSet() {
		return impl.maker.get();
	}


}
