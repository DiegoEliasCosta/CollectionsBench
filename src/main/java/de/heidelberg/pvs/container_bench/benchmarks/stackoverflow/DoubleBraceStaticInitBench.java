package de.heidelberg.pvs.container_bench.benchmarks.stackoverflow;

import java.util.ArrayList;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

/**
 * Benchmark that evaluates double brace initialization on an ArrayList Taken
 * from the top #1 most voted question on Collections performance
 * https://stackoverflow.com/questions/924285/efficiency-of-java-double-brace-initialization
 * 
 * Simple tests 1. Create a small collection with 2 elements with and without
 * double bracer 2. Create a larger collection with 20 elements with and without
 * double bracer
 * 
 * I believe anything about that would not be created statically.
 * 
 * @author diego.costa
 *
 */
public class DoubleBraceStaticInitBench extends StackOverflowQuestionsBench {

	// Keeping in conformity with the structure of other benchmarks
	@Param
	ArrayListImpl impl;

	enum ArrayListImpl {
		JDK_ARRAYLIST
	} // This cannot be done through our factory

	@Param
	DoubleBraceWorkload workload;

	enum DoubleBraceWorkload {
		SO_STATIC_INITIALIZATION_WORKLOAD
	};

	@Param
	PayloadType payloadType;

	enum PayloadType {
		STRING
	};

	@Param
	int size = -1;

	@Param
	int seed = -1;

	@Benchmark
	public List<String> smallListInitializationWithDoubleBrace() throws InterruptedException {
		@SuppressWarnings("serial")
		List<String> l = new ArrayList<String>() {
			{
				add("Hello");
				add("World!");
			}
		};
		return l;
	};

	
	@Benchmark
	public List<String> smallListInitializationRegular() throws InterruptedException {
		List<String> l = new ArrayList<String>();
		l.add("Hello");
		l.add("World!");
		return l;
	};

	@Benchmark
	public List<String> largerListInitializationWithDoubleBrace() throws InterruptedException {
		@SuppressWarnings("serial")
		List<String> l = new ArrayList<String>() {
			{
				add("Hello");
				add("World!");
				add("Lorem");
				add("ipsum");
				add("dolor");
				add("sit");
				add("amet,");
				add("consectetur");
				add("adipiscing");
				add("elit.");
				add("Integer");
				add("viverra");
				add("enim");
				add("nec");
				add("ex");
				add("maximus");
				add("commodo.");
				add("Suspendisse");
				add("ullamcorper");
				add("ornare.");
			}
		};
		return l;
	};

	@Benchmark
	public List<String> largerListInitializationRegular() throws InterruptedException {
		List<String> l = new ArrayList<String>();
		l.add("Hello");
		l.add("World!");
		l.add("Lorem");
		l.add("ipsum");
		l.add("dolor");
		l.add("sit");
		l.add("amet,");
		l.add("consectetur");
		l.add("adipiscing");
		l.add("elit.");
		l.add("Integer");
		l.add("viverra");
		l.add("enim");
		l.add("nec");
		l.add("ex");
		l.add("maximus");
		l.add("commodo.");
		l.add("Suspendisse");
		l.add("ullamcorper");
		l.add("ornare.");
		return l;
	};


}
