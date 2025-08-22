package io.github.manoelcampos.benchmarks;

import org.openjdk.jmh.annotations.*;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.github.manoelcampos.benchmarks.Util.MIDDLE;

/**
 * Benchmarks to measure the performance operations of different
 * {@link List} implementations.
 *
 * @author Manoel Campos
 */
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
public class ListsBenchmark {
    /**
     * It doesn't use the {@link ListState} as a parameter
     * because the goal is to measure the time to populate
     * a given List implementation.
     */
    @Benchmark
    public List<String> arrayListPopulation(){
        return Util.populateNewList(Util.NEW_ARRAY_LIST_SUPPLIER);
    }

    /**
     * It doesn't use the {@link ListState} as a parameter
     * because the goal is to measure the time to populate
     * a given List implementation.
     */
    @Benchmark
    public List<String> linkedListPopulation(){
        return Util.populateNewList(LinkedList::new);
    }

    /**
     * Since there is an {@link Param} annotation
     * for one of the {@link ListState} attributes,
     * this benchmark will be executed
     * once for each value of the {@link ListState#getListType()} parameterized attribute.
     * @param state a State object containing the list implementation to be used in the benchmark
     */
    @Benchmark
    public List<String> listMiddleRemoval(final ListState state){
        state.getList().remove(MIDDLE);
        return state.getList();
    }
}
