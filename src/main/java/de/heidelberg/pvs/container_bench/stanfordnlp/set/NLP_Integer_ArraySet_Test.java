package de.heidelberg.pvs.container_bench.stanfordnlp.set;

import java.util.Set;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKSetTest;
import edu.stanford.nlp.util.ArraySet;

public class NLP_Integer_ArraySet_Test extends AbstractJDKSetTest<Integer> {

	@Override
	protected Set<Integer> getNewSet() {
		return new ArraySet<>();
	}

	@Override
	protected Set<Integer> copySet(Set<Integer> fullSet2) {
		// NLP ArraySet does not offer a copy constructor
		ArraySet<Integer> arraySet = new ArraySet<>();
		arraySet.addAll(fullSet2);
		return arraySet;
	}

}
