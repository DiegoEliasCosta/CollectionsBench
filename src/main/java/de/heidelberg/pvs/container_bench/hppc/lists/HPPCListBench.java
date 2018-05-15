package de.heidelberg.pvs.container_bench.hppc.lists;

import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.ObjectIndexedContainer;

import de.heidelberg.pvs.container_bench.benchmarks.singleoperations.lists.AbstractHPPCListBench;
import de.heidelberg.pvs.container_bench.factories.HPPCListFact;

public class HPPCListBench extends AbstractHPPCListBench<Object>{

	@Param
	HPPCListFact impl;
	
	@Override
	protected ObjectIndexedContainer<Object> getNewList() {
		return impl.maker.get();
	}

	@Override
	protected ObjectIndexedContainer<Object> copyList(ObjectIndexedContainer<Object> original) {
		return impl.copyMaker.apply(original);
	}

}
