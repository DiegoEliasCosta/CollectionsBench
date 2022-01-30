package container.benchmarks.singleoperations.maps;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

import container.factories.ScalaMapFact;
import scala.Tuple2;
import scala.collection.Iterator;
import scala.collection.mutable.Map;

public class ScalaMapBench extends AbstractMapBench<Object, Integer> {
	private Map<Object, Integer> fullMap;
	private Object[] keys;
	private Integer[] values;

	@Param
	public ScalaMapFact impl;

	@Param
	public ScalaMapWorkload workload;

	@SuppressWarnings("unchecked")
	protected Map<Object, Integer> getNewMap() {
		return (Map<Object, Integer>) impl.maker.get();
	}

	protected Map<Object, Integer> copyMap(Map<Object, Integer> fullMap2) {
		Map<Object, Integer> map = this.getNewMap();
		map.$plus$plus$eq(fullMap2);
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

	public enum ScalaMapWorkload {
		POPULATE {
			@Override
			void run(ScalaMapBench self) {
				Map<Object, Integer> newMap = self.getNewMap();
				for (int i = 0; i < self.size; i++) {
					newMap.put(self.keys[i], self.values[i]);
				}
				self.blackhole.consume(newMap);
			}
		},

		CONTAINS {
			@Override
			void run(ScalaMapBench self) {
				int index = self.keyGenerator.generateIndex(self.size);
				self.blackhole
						.consume(((scala.collection.Map<Object, Integer>) self.fullMap).contains(self.keys[index]));
			}
		},

		COPY {
			@Override
			void run(ScalaMapBench self) {
				Map<Object, Integer> newMap = self.copyMap(self.fullMap);
				self.blackhole.consume(newMap);
			}
		},

		ITERATE {
			@Override
			void run(ScalaMapBench self) {
				for (Iterator<Tuple2<Object, Integer>> it = self.fullMap.iterator(); it.hasNext();) {
					self.blackhole.consume(it.next());
				}
			}
		};

		abstract void run(ScalaMapBench self);
	}
}
