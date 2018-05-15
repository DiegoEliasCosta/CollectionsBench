package de.heidelberg.pvs.container_bench.hppc.sets;

import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.ObjectSet;

import de.heidelberg.pvs.container_bench.benchmarks.singleoperations.sets.AbstractHPPCSetBench;
import de.heidelberg.pvs.container_bench.factories.HPPCSetFact;

public class HPPCSetBench extends AbstractHPPCSetBench<Object>{

	@Param
	HPPCSetFact impl;
	
	@Override
	protected ObjectSet<Object> getNewSet() {
		return impl.maker.get();
	}

	@Override
	protected ObjectSet<Object> copySet(ObjectSet<Object> original) {
		return impl.copyMaker.apply(original);
	}

}
