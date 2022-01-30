package container.benchmarks.singleoperations.lists;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

import scala.collection.Iterator;
import scala.collection.mutable.Buffer;
import container.factories.ScalaListFact;

public class ScalaListBench extends AbstractListBench<Object> {
	Buffer<Object> fullList;
	Object[] values;

	@Param
	public ScalaListFact impl;

	@Param
	public ScalaListWorkload workload;

	@SuppressWarnings("unchecked")
	protected Buffer<Object> getNewList() {
		return (Buffer<Object>) impl.maker.get();
	}

	@Override
	public void testSetup() {
		fullList = this.getNewList();
		values = this.generator.generateArray(size);
		for (int i = 0; i < size; i++) {
			fullList.append(values[i]);
		}
	}

	@Benchmark
	public void bench() {
		workload.run(this);
		blackhole.consume(fullList);
	}

	public enum ScalaListWorkload {
		ITERATE {
			@Override
			public void run(ScalaListBench self) {
				for (Iterator<Object> it = self.fullList.iterator(); it.hasNext();) {
					self.blackhole.consume(it.next());
				}
			}
		}, //

		GET_INDEX {
			@Override
			public void run(ScalaListBench self) {
				int index = self.generator.generateIndex(self.size);
				self.blackhole.consume(((scala.collection.Seq<Object>) self.fullList).apply(index));
			}
		}, //

		CONTAINS {
			@Override
			public void run(ScalaListBench self) {
				int index = self.generator.generateIndex(self.size);
				self.blackhole.consume(((scala.collection.Seq<Object>) self.fullList).contains(self.values[index]));

			}
		}, //

		POPULATE {
			@Override
			public <T> void run(ScalaListBench self) {
				Buffer<Object> newList = self.getNewList();
				for (int i = 0; i < self.size; i++) {
					newList.append(self.values[i]);
				}
				self.blackhole.consume(newList);
			}
		}, //

		COPY {
			@Override
			public void run(ScalaListBench self) {
				Buffer<Object> newList = self.getNewList();
				newList.appendAll(self.fullList);
				self.blackhole.consume(newList);
			}
		};
		// TODO: Add more scenarios for single operation

		abstract public <T> void run(ScalaListBench self);
	}
}
