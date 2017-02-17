package de.heidelberg.pvs.container_bench.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.gs.collections.impl.list.mutable.FastList;

import junit.framework.Assert;

public class JDKArrayListTest {

	int SIZE = 100; 
	
	@Test
	public void testArrayListAddAll() throws Exception {
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < SIZE; i++) {
			list.add(i);
		}
		
		Assert.assertEquals(SIZE, list.size());
	}
	
	@Test
	public void testFastListAddAll() throws Exception {
		
		List<Integer> list = new FastList<>();
		
		for(int i = 0; i < SIZE; i++) {
			list.add(i);
		}
		
		Assert.assertEquals(SIZE, list.size());
	}

	@Test
	public void testName() throws Exception {
		
		int number = 100;
		
		number += number >> 1;
		
	}
	
}
