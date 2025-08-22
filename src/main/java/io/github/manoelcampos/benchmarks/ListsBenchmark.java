package io.github.manoelcampos.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

import static io.github.manoelcampos.benchmarks.Util.LIST_SIZE;
import static io.github.manoelcampos.benchmarks.Util.MIDDLE;

/**
 * @author Manoel Campos
 */
public class ListsBenchmark {
    public static final Supplier<List<String>> NEW_ARRAY_LIST_SUPPLIER = () -> new ArrayList<>(LIST_SIZE);

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public List<String> arrayListPopulation(){
        return Util.populateNewList(NEW_ARRAY_LIST_SUPPLIER);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public List<String> linkedListPopulation(){
        return Util.populateNewList(LinkedList::new);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public List<String> arrayListMiddleRemoval(){
        final var list = Util.populateNewList(NEW_ARRAY_LIST_SUPPLIER);
        list.remove(MIDDLE);
        return list;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public List<String> linkedListMiddleRemoval(){
        final var list = Util.populateNewList(LinkedList::new);
        list.remove(MIDDLE);
        return list;
    }
}
