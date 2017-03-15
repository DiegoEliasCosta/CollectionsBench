package de.heidelberg.pvs.container_bench.jdk.lists;

import java.util.ArrayList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;

public class JDK_String_ArrayList_Test extends AbstractJDKListTest<String> {

	@Override
	protected List<String> getNewList() {
		return new ArrayList<String>();
	}

	@Override
	protected List<String> copyList(List<String> fullList2) {
		return new ArrayList<String>(fullList2);
	}

}
