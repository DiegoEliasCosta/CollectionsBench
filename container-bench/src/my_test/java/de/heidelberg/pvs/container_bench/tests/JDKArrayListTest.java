package de.heidelberg.pvs.container_bench.tests;

import org.junit.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import junit.framework.Assert;

public class JDKArrayListTest {

	@Test
	public void testListsBasicRunner() throws Exception {

		try {
			Options opt = new OptionsBuilder().include(JDKArrayListTest.class.getSimpleName()).build();
			new Runner(opt).run();

		} catch (Exception e) {
			Assert.assertFalse(true);
			
		}

	}

}
