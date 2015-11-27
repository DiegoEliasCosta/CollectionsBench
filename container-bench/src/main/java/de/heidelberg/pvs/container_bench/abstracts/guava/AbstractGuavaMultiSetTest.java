package de.heidelberg.pvs.container_bench.abstracts.guava;

import com.google.common.collect.Multiset;

import de.heidelberg.pvs.container_bench.abstracts.AbstractSetTest;

public abstract class AbstractGuavaMultiSetTest<T> extends AbstractSetTest {

	private T[] values;
	private Multiset<T> fullSet;
	
	protected abstract Multiset<T> getNewMultiSet();
	
	@Override
	public void testSetup() {
		fullSet = this.getNewMultiSet();
	}
	

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeElement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void containsElement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void instantiate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void copySet() {
		// TODO Auto-generated method stub
		
	}


}
