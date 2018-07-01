package de.heidelberg.pvs.container_bench.benchmarks.concurrency.lists;

import java.io.IOException;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Group;
import org.openjdk.jmh.annotations.GroupThreads;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.infra.Blackhole;

import de.heidelberg.pvs.container_bench.benchmarks.concurrency.AbstractConcurrentBench;
import de.heidelberg.pvs.container_bench.factories.JDKSyncListFact;
import de.heidelberg.pvs.container_bench.generators.ElementGenerator;
import de.heidelberg.pvs.container_bench.generators.GeneratorFactory;
import de.heidelberg.pvs.container_bench.generators.PayloadType;

public class JDKConcurrentListBench extends AbstractConcurrentBench {

	@Param
	JDKSyncListFact impl;

	String values[];

	ElementGenerator<String> valuesGenerator;

	Blackhole blackhole;

	List<Object> sharedEmptyList;

	@Param("STRING_DICTIONARY")
	PayloadType payloadType;

	@Setup(Level.Iteration)
	@SuppressWarnings("unchecked")
	public void setup(Blackhole bh) throws IOException {
		sharedEmptyList = impl.maker.get();

		valuesGenerator = (ElementGenerator<String>) GeneratorFactory.buildRandomGenerator(PayloadType.STRING_DICTIONARY);
		valuesGenerator.init(size, seed);

		values = valuesGenerator.generateArray(size);

		blackhole = bh;

	}

	@Benchmark
	@Group("readAndWrite")
	@GroupThreads(10)
	public void readFromState() {
		int index = valuesGenerator.generateIndex(size);
		blackhole.consume(sharedEmptyList.contains(values[index]));

	}

	@Benchmark
	@Group("readAndWrite")
	@GroupThreads(1)
	public void writeOnState() {
		for (int i = 0; i < size; i++) {
			sharedEmptyList.add(values[i]);
		}
	}

	@Benchmark
	@Group("searchAndAdd")
	@GroupThreads(10)
	public void searchAndAdd() {

		int index = this.valuesGenerator.generateIndex(size);
		if (!sharedEmptyList.contains(values[index])) {
			sharedEmptyList.add(values[index]);
		}
	}

	@Benchmark
	@Group("addAndRemove")
	@GroupThreads(1)
	public void add() {
		int index = this.valuesGenerator.generateIndex(size);
		sharedEmptyList.add(values[index]);
	}

	@Benchmark
	@Group("addAndRemove")
	@GroupThreads(1)
	public void remove() {
		int index = this.valuesGenerator.generateIndex(size);
		sharedEmptyList.remove(values[index]);
	}

}
