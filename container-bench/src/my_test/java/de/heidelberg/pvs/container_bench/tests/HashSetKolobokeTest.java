package de.heidelberg.pvs.container_bench.tests;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;
import net.openhft.koloboke.collect.set.hash.HashObjSet;
import net.openhft.koloboke.collect.set.hash.HashObjSets;

public class HashSetKolobokeTest {
	
	@Test
	public void testCopyHashSet() throws Exception {
		
		Set<Integer> hashSet = HashObjSets.newMutableSet();
	
		int initialSize = 10000000;
		for(int i = 0; i < initialSize; i++) {
			hashSet.add(i);
		}
		
		HashObjSet<Integer> copiedSet = HashObjSets.newMutableSet(hashSet);
		
		int size = copiedSet.size();
		Assert.assertEquals(initialSize, size);
		
		Assert.assertTrue(copiedSet.containsAll(hashSet));
		
		int remove = initialSize / 100;
		for(int i = 0; i < initialSize; i++) {
			hashSet.remove(i);
		}
		
		for(int i = 0; i < remove; i++) {
			Assert.assertTrue(copiedSet.contains(i));
		}
		
		
	}
	
	@Test
	public void testName() throws Exception {
		
	}

}
