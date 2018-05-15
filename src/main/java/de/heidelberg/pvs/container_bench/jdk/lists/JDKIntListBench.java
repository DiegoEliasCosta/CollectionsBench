package de.heidelberg.pvs.container_bench.jdk.lists;

import java.util.List;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.benchmarks.singleoperations.lists.AbstractJDKListBench;
import de.heidelberg.pvs.container_bench.factories.JDKIntListFact;

public class JDKIntListBench extends AbstractJDKListBench<Integer> {

	@Param
	private JDKIntListFact impl;
	
	@Override
	protected List<Integer> getNewList() {
		return impl.maker.get();
	}

}