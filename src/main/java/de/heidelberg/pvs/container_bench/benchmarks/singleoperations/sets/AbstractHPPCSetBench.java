package de.heidelberg.pvs.container_bench.benchmarks.singleoperations.sets;

import java.util.Set;

import org.openjdk.jmh.annotations.Param;

import com.carrotsearch.hppc.ObjectSet;

import de.heidelberg.pvs.container_bench.factories.HPPCSetFact;

/**
 * Abstract class for every test with HPPC Sets implementation
 * 
 * @author Diego
 *
 */
public class AbstractHPPCSetBench extends AbstractSetBench<Object> {

	private ObjectSet<Object> fullSet;
	private Object[] values;
	private Object[] newValues;
	private int newValuesSize;

	@Param
	HPPCSetFact impl;
	
	@Param
	SingleOperationWorkload workload;

	protected ObjectSet<Object> getNewSet() {
		return impl.maker.get();
	}

	protected ObjectSet<Object> copySet(ObjectSet<Object> original) {
		return impl.copyMaker.apply(original);
	}

	public void testSetup() {
		newValuesSize = 2 * size; // 50% of colision
		fullSet = this.getNewSet();
		values = generator.generateArray(size);
		newValues = generator.generateArray(2 * size);
		for (int i = 0; i < size; i++) {
			fullSet.add(values[i]);
		}
	}

	private enum SingleOperationWorkload {

		POPULATE {
			@Override
			void run(AbstractHPPCSetBench self) {
				ObjectSet<Object> newSet = self.getNewSet();
				for (int i = 0; i < self.size; i++) {
					newSet.add(self.values[i]);
				}
				self.blackhole.consume(newSet);
			}
		}, //

		ITERATE {
			@Override
			void run(AbstractHPPCSetBench self) {
				for (Object element : self.fullSet) {
					self.blackhole.consume(element);
				}
			}
		},

		COPY {
			@Override
			void run(AbstractHPPCSetBench self) {
				ObjectSet<Object> newSet = self.copySet(self.fullSet);
				self.blackhole.consume(newSet);
			}
		},

		CONTAINS {

			@Override
			void run(AbstractHPPCSetBench self) {
				int index = self.generator.generateIndex(self.size);
				self.blackhole.consume(self.fullSet.contains(self.values[index]));
			}
		};

		abstract void run(AbstractHPPCSetBench self);

	}

}