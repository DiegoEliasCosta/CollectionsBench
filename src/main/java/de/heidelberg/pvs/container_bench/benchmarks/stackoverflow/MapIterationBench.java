package de.heidelberg.pvs.container_bench.benchmarks.stackoverflow;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.benchmarks.singleoperations.AbstractSingleOperationsBench;
import de.heidelberg.pvs.container_bench.generators.ElementGenerator;
import de.heidelberg.pvs.container_bench.generators.GeneratorFactory;

public class MapIterationBench extends AbstractSingleOperationsBench {
	
	// Keeping in conformity with the structure of other benchmarks
	@Param
	public JDKHashMapFact impl;
	public enum JDKHashMapFact { JDK_HASH }; // fixed
	
	Map<Object, Object> fullMap;

	@Param
	public MapIterationWorkload workload;
	public enum MapIterationWorkload {	SO_MAP_ITERATE	}; // fixed

	private ElementGenerator<Object> generator;
	
	@SuppressWarnings("unchecked")
	@Override
	public void generatorSetup() throws IOException {
		generator = (ElementGenerator<Object>) GeneratorFactory.buildRandomGenerator(payloadType);
		generator.init(size, seed);
	}

	@Override
	public void testSetup() {
		fullMap = new HashMap<Object, Object>();
		Object[] values = this.generator.generateArray(size);
		for (int i = 0; i < size; i++) {
			fullMap.put(values[i], values[i]);
		}
	}
	
	@Benchmark
	public void entrySetLoop() {
		
		for(Entry<Object,Object> entrySet : fullMap.entrySet()) {
			
			Object key = entrySet.getKey();
			Object value = entrySet.getValue();
			
			this.blackhole.consume(key);
			this.blackhole.consume(value);
		}
	}
	
	@Benchmark
	public void iteratorLoop() {
		
		Iterator<Entry<Object, Object>> iterator = fullMap.entrySet().iterator();
		
		while(iterator.hasNext()) {
			
			Entry<Object, Object> entry = iterator.next();
			
			Object key = entry.getKey();
			Object value = entry.getValue();
			
			this.blackhole.consume(key);
			this.blackhole.consume(value);
		}
	}
	
	@Benchmark
	public void keySetLoop() {
		
		for(Object key : fullMap.keySet()) {
			Object value = fullMap.get(key);
			
			this.blackhole.consume(key);
			this.blackhole.consume(value);
		}
	}

	@Benchmark
	public void forEachLoop() {
		fullMap.forEach((key, value) -> {
			this.blackhole.consume(key);
			this.blackhole.consume(value);
		});
	}
	
}
