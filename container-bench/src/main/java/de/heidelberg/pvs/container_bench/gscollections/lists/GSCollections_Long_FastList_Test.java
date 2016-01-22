package de.heidelberg.pvs.container_bench.gscollections.lists;

import java.util.List;

import com.gs.collections.impl.list.mutable.FastList;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;
import de.heidelberg.pvs.container_bench.random.LongRandomGenerator;
import de.heidelberg.pvs.container_bench.random.RandomGenerator;

public class GSCollections_Long_FastList_Test extends AbstractJDKListTest<Long>{

	@Override
	protected List<Long> getNewList(int size) {
		return new FastList<Long>();
	}

	@Override
	protected List<Long> copyList(List<Long> fullList2) {
		return new FastList<Long>(fullList2);
	}

	@Override
	protected RandomGenerator<Long> instantiateRandomGenerator() {
		return new LongRandomGenerator();
	}

}
