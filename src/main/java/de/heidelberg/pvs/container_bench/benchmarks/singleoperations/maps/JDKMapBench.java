package de.heidelberg.pvs.container_bench.benchmarks.singleoperations.maps;

import java.util.Map;
import java.util.Map.Entry;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

import de.heidelberg.pvs.container_bench.factories.JDKMap2IntFact;

public class JDKMapBench extends AbstractMapBench<Object, Integer> {
	private Map<Object, Integer> fullMap;
	protected Object[] keys;
	protected Integer[] values;

	@Param
	public JDKMap2IntFact impl;

	@Param
	public JDKMapWorkload workload;

	protected Map<Object, Integer> getNewMap() {
		return impl.maker.get();
	}

	protected Map<Object, Integer> copyMap(Map<Object, Integer> fullMap2) {
		Map<Object, Integer> map = this.getNewMap();
		map.putAll(fullMap2);
		return map;
	}

	@Override
	public void testSetup() {
		// int varietyOfKeys = (int) (size * ((double) percentageRangeKeys / 100));
		fullMap = this.getNewMap();

		keys = keyGenerator.generateArray(size);
		values = valueGenerator.generateArray(size);

		for (int i = 0; i < size && failIfInterrupted(); i++) {
			fullMap.put(keys[i], values[i]);
		}
	}

	@Benchmark
	public void bench() {
		workload.run(this);
		blackhole.consume(fullMap);
	}

	public enum JDKMapWorkload {
		POPULATE {
			@Override
			public void run(JDKMapBench self) {
				Map<Object, Integer> newMap = self.getNewMap();
				for (int i = 0; i < self.size && failIfInterrupted(); i++) {
					self.blackhole.consume(newMap.put(self.keys[i], self.values[i]));
				}
				self.blackhole.consume(newMap);
			}
		}, //

		CONTAINS {
			@Override
			public void run(JDKMapBench self) {
				int index = self.keyGenerator.generateIndex(self.size);
				self.blackhole.consume(self.fullMap.containsKey(self.keys[index]));
			}
		}, //

		COPY {
			@Override
			public void run(JDKMapBench self) {
				Map<Object, Integer> newMap = self.copyMap(self.fullMap);
				self.blackhole.consume(newMap);
			}
		}, //

		ITERATE {
			@Override
			public void run(JDKMapBench self) {
				for (Entry<Object, Integer> entry : self.fullMap.entrySet()) {
					failIfInterrupted();
					self.blackhole.consume(entry);
				}
			}
		};

		public abstract void run(JDKMapBench self);
	}
}
