package container.benchmarks.singleoperations.lists;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;

import scala.collection.Iterator;
import scala.collection.mutable.Seq;
import container.factories.ScalaListFact;

public class ScalaListBench extends AbstractListBench<Object> {
	Seq<Object> fullList;
	Object[] values;

	@Param
	public ScalaListFact impl;

	@Param
	public ScalaListWorkload workload;

	@SuppressWarnings("unchecked")
	protected Seq<Object> getNewList() {
		return (Seq<Object>) impl.maker.get();
	}

	@Override
	public void testSetup() {
		fullList = this.getNewList();
		values = this.generator.generateArray(size);
		for (int i = 0; i < size; i++) {
			((scala.collection.Seq<Object>) fullList).$colon$plus(values[i]);
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
				Seq<Object> newList = self.getNewList();
				for (int i = 0; i < self.size; i++) {
					((scala.collection.Seq<Object>) newList).$colon$plus(self.values[i]);
				}
				self.blackhole.consume(newList);
			}
		}, //

		COPY {
			@Override
			public void run(ScalaListBench self) {
				@SuppressWarnings("unchecked")
				Seq<Object> newList = ((scala.collection.mutable.Seq<Object>) self).clone();
				self.blackhole.consume(newList);
			}
		};
		// TODO: Add more scenarios for single operation

		abstract public <T> void run(ScalaListBench self);
	}
}
