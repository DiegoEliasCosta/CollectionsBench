package de.heidelberg.pvs.container_bench.jdk.lists;

import java.util.LinkedList;
import java.util.List;

import de.heidelberg.pvs.container_bench.abstracts.jdk.AbstractJDKListTest;

public class JDK_String_LinkedList_Test extends AbstractJDKListTest<String> {

	@Override
	protected List<String> getNewList() {
		return new LinkedList<String>(); 
	}

	@Override
	protected List<String> copyList(List<String> fullList2) {
		return new LinkedList<String>(fullList2);
	}
}
