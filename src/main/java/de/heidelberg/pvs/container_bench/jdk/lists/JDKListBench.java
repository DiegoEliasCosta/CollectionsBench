package de.heidelberg.pvs.container_bench.jdk.lists;

import java.util.List;

import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListBench;
import de.heidelberg.pvs.container_bench.factories.JDKListFact;

public class JDKListBench extends AbstractJDKListBench<Object> {

	@Param
	JDKListFact impl;
	
	@Override
	protected List<Object> getNewList() {
		return impl.maker.get();
	}

}
