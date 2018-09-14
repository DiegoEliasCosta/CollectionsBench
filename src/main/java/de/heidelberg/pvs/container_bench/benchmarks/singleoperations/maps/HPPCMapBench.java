package de.heidelberg.pvs.container_bench.benchmarks.singleoperations.maps;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.ObjectObjectMap;
import com.carrotsearch.hppc.cursors.ObjectObjectCursor;

import de.heidelberg.pvs.container_bench.factories.HPPCMapFact;

public class HPPCMapBench extends AbstractMapBench<Object, Integer> {

	private ObjectObjectMap<Object, Integer> fullMap;
	private Object[] keys;
	private Integer[] values;

	@Param
	public HPPCMapFact impl;

	@Param
	public HPPCMapWorkload workload;

	protected ObjectObjectMap<Object, Integer> getNewMap() {
		return impl.maker.get();
	}

	protected ObjectObjectMap<Object, Integer> copyMap(ObjectObjectMap<Object, Integer> fullMap2) {
		ObjectObjectMap<Object, Integer> map = this.getNewMap();
		map.putAll(fullMap2);
		return map;
	}

	@Override
	public void testSetup() {
		fullMap = this.getNewMap();

		keys = keyGenerator.generateArray(size);
		values = valueGenerator.generateArray(size);

		for (int i = 0; i < size; i++) {
			fullMap.put(keys[i], values[i]);
		}

	}
	
	@Benchmark
	public void bench() throws InterruptedException {
		workload.run(this);
		blackhole.consume(fullMap);
	}

	public enum HPPCMapWorkload {

		POPULATE {
			@Override
			void run(HPPCMapBench self) {
				ObjectObjectMap<Object, Integer> newMap = self.getNewMap();
				for (int i = 0; i < self.size; i++) {
					newMap.put(self.keys[i], self.values[i]);
				}
				self.blackhole.consume(newMap);
			}
		},

		CONTAINS {
			@Override
			void run(HPPCMapBench self) {
				int index = self.keyGenerator.generateIndex(self.size);
				self.blackhole.consume(self.fullMap.containsKey(self.keys[index]));
			}
		}, 
		
		COPY {
			@Override
			void run(HPPCMapBench self) {
				ObjectObjectMap<Object, Integer> newMap = self.copyMap(self.fullMap);
				self.blackhole.consume(newMap);
			}
		}, 
		
		ITERATE {
			@Override
			void run(HPPCMapBench self) {
				for (ObjectObjectCursor<Object, Integer> c : self.fullMap) {
					self.blackhole.consume(c.key);
					self.blackhole.consume(c.value);
				}
			}
		};

		abstract void run(HPPCMapBench self);

	}

}
