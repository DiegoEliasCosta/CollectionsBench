package de.heidelberg.pvs.container_bench.tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;
import net.openhft.koloboke.collect.set.hash.HashObjSet;
import net.openhft.koloboke.collect.set.hash.HashObjSets;

public class HashSetKolobokeTest {
	
	@Test
	public void testCopyKoloboke() throws Exception {
		
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
		for(int i = 0; i < remove; i++) {
			hashSet.remove(i);
		}
		
		for(int i = 0; i < remove; i++) {
			Assert.assertTrue(copiedSet.contains(i));
		}
	}
	
	@Test
	public void testCopyJDK() throws Exception {
		
		Set<Integer> hashSet = new HashSet<>();
		
		int initialSize = 10000000;
		for(int i = 0; i < initialSize; i++) {
			hashSet.add(i);
		}
		
		Set<Integer> copiedSet = new HashSet<>(hashSet);
		
		int size = copiedSet.size();
		Assert.assertEquals(initialSize, size);
		
		Assert.assertTrue(copiedSet.containsAll(hashSet));
		
		int remove = initialSize / 100;
		for(int i = 0; i < remove; i++) {
			hashSet.remove(i);
		}
		
		for(int i = 0; i < remove; i++) {
			Assert.assertTrue(copiedSet.contains(i));
		}
		
	}

}
