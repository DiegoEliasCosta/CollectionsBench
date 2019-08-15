package de.heidelberg.pvs.container_bench.benchmarks.stackoverflow;

import com.google.common.collect.Iterables;
import de.heidelberg.pvs.container_bench.benchmarks.singleoperations.AbstractSingleOperationsBench;
import de.heidelberg.pvs.container_bench.generators.ElementGenerator;
import de.heidelberg.pvs.container_bench.generators.GeneratorFactory;
import de.heidelberg.pvs.container_bench.generators.PayloadType;
import org.apache.commons.collections4.CollectionUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterComparisonCollectionBench extends AbstractSingleOperationsBench {

    /**
     * Type of the payload object
     */
    @Param
    public PayloadType payloadType = PayloadType.INTEGER_UNIFORM;

    // Keeping in conformity with the structure of other benchmarks
    @Param
    public IterationOnListsBench.ArrayListImpl impl;
    public enum ArrayListImpl {
        JDK_ARRAYLIST
    } // This cannot be done through our factory
    public ElementGenerator<Integer> generator;

    @Param
    public IterationOnListsBench.ListIterationWorkload workload;
    public enum ListIterationWorkload { SO_LIST_FILTER };

    private Integer values[];
    private Integer middle;
    protected List<Integer> fullList;
    protected List<Integer> copyList;

    @Override
    public void generatorSetup() throws IOException {
        generator = (ElementGenerator<Integer>) GeneratorFactory.buildRandomGenerator(payloadType);
        generator.init(size, seed);
    }

    @Override
    public void testSetup() {
        fullList = new ArrayList<>();
        values = this.generator.generateArray(size);
        for (int i = 0; i < size; i++) {
            fullList.add(values[i]);
        }

        middle = (Integer) Arrays.stream(values).sorted().toArray()[values.length / 2];

    }

    @Setup(value = Level.Invocation)
    public void copyListSetup() {

        // We should always avoid using Level.invocation as this falls in one of
        // the bad practices in JMH benchmark creation
        // https://hg.openjdk.java.net/code-tools/jmh/file/99d7b73cf1e3/jmh-samples/src/main/java/org/openjdk/jmh/samples/JMHSample_07_FixtureLevelInvocation.java

        // This needs to be done as some benchmarks modify the collection in place.
        // That being said, we need to make sure this won't add too much overhead
        // to the benchmark in our analysis, otherwise we can just include the copy
        // in all benchmarks to make things fair...
        copyList = new ArrayList<>(fullList);
    }

    @Benchmark
    public List<Integer> streamFilter() {
        return fullList.stream().filter(e -> e > middle).collect(Collectors.toList());
    }

    @Benchmark
    public List<Integer> removeIfFilter() {
        copyList.removeIf(e -> e > middle);
        return copyList;

    }

    @Benchmark
    public List<Integer> apacheCommonsFilter() {
        CollectionUtils.filter(copyList, e -> e > middle);
        return copyList;
    }

    @Benchmark
    public List<Integer> guavaFilter() {
        Iterables.filter(copyList, e -> e > middle);
        return copyList;
    }

}
