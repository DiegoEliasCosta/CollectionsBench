package container.benchmarks.singleoperations.sets;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

import container.factories.ScalaSetFact;
import scala.collection.Iterator;
import scala.collection.mutable.Set;

/**
 * Abstract class for every test with Scala Sets implementation
 * 
 * @author Erich
 */
public class ScalaSetBench extends AbstractSetBench<Object> {
	private Set<Object> fullSet;
	private Object[] values;

	@Param
	public ScalaSetFact impl;

	@Param
	public ScalaSetWorkload workload;

	@SuppressWarnings("unchecked")
	protected Set<Object> getNewSet() {
		return (Set<Object>) impl.maker.get();
	}

	public void testSetup() {
		fullSet = this.getNewSet();
		values = generator.generateArray(size);
		for (int i = 0; i < size; i++) {
			fullSet.add(values[i]);
		}
	}

	@Benchmark
	public void bench() throws InterruptedException {
		workload.run(this);
		blackhole.consume(fullSet);
	}

	public enum ScalaSetWorkload {
		POPULATE {
			@Override
			void run(ScalaSetBench self) {
				Set<Object> newSet = self.getNewSet();
				for (int i = 0; i < self.size; i++) {
					newSet.add(self.values[i]);
				}
				self.blackhole.consume(newSet);
			}
		}, //

		ITERATE {
			@Override
			void run(ScalaSetBench self) {
				for (Iterator<Object> it = self.fullSet.iterator(); it.hasNext();) {
					self.blackhole.consume(it.next());
				}
			}
		},

		COPY {
			@Override
			void run(ScalaSetBench self) {
				Set<Object> newSet = self.getNewSet();
				newSet.addAll(self.fullSet);
				self.blackhole.consume(newSet);
			}
		},

		CONTAINS {
			@Override
			void run(ScalaSetBench self) {
				int index = self.generator.generateIndex(self.size);
				self.blackhole.consume(((scala.collection.Set<Object>) self.fullSet).contains(self.values[index]));
			}
		};

		abstract void run(ScalaSetBench self);
	}
}