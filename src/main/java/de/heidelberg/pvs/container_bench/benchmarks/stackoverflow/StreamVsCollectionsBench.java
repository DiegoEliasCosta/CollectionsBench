package de.heidelberg.pvs.container_bench.benchmarks.stackoverflow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;

import de.heidelberg.pvs.container_bench.generators.ElementGenerator;
import de.heidelberg.pvs.container_bench.generators.uniform.IntegerUniformGenerator;

/**
 * 
 * @author diego
 *
 */
public class StreamVsCollectionsBench extends StackOverflowQuestionsBench {

	/**
	 * From 100 - 1M
	 */
	@Param({ "100", "1000", "10000", "100000", "1000000" })
	public int size;
	
	@Param
	ArrayListFact impl;
	public enum ArrayListFact { JDK_ARRAY } // fixed
	
	@Param
	PayloadType payloadType;
	public enum PayloadType { INTEGER_UNIFORM } // fixed
	
	@Param
	StreamVsCollectionWorkload workload;
	public enum StreamVsCollectionWorkload { SO_FILTERING_ADDING }
	
	@Param({ "467505" })
	public int seed;
	
	List<Integer> fullList;
	ElementGenerator<Integer> generator;
	
	@Setup
	public void setup() throws IOException {
		fullList = new ArrayList<>();
		generator = new IntegerUniformGenerator();
		generator.init(size, seed);
		Integer[] values = this.generator.generateArray(size);
		for(int i = 0; i < size; i++) {
			fullList.add(values[i]);
		}
		
	}
	
	
	@Benchmark
    public List<Double> collectionAPI() {
        List<Double> result = new ArrayList<>(fullList.size() / 2 + 1);
        for (Integer i : fullList) {
            if (i % 2 == 0){
                result.add(Math.sqrt(i));
            }
        }
        return result;
    }

    @Benchmark
    public List<Double> streamAPI() {
        return fullList.stream()
                .filter(i -> i % 2 == 0)
                .map(Math::sqrt)
                .collect(Collectors.toCollection(
                    () -> new ArrayList<>(fullList.size() / 2 + 1)));
    }

}
