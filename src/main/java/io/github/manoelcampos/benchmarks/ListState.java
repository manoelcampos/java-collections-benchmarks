package io.github.manoelcampos.benchmarks;

import org.openjdk.jmh.annotations.*;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Create a different kinds of lists to be used in some parameterized benchmarks.
 * This way, those benchmark won't measure the list creation time.
 * @author Manoel Campos
 */
@State(Scope.Thread)
public class ListState {
    /**
     * Each benchmark that uses this state as a parameter
     * will be executed once for each value of this attribute,
     * enabling it to be executed with different implementations of List.
     */
    @Param({"ArrayList", "LinkedList"})
    private String listType;

    private List<String> list;

    @Setup(Level.Invocation)
    public void setUp() {
        list = Util.populateNewList(emptyListCreator());
    }

    private Supplier<List<String>> emptyListCreator() {
        return "ArrayList".equals(listType) ? Util.NEW_ARRAY_LIST_SUPPLIER : LinkedList::new;
    }

    public String getListType() {
        return listType;
    }

    public List<String> getList() {
        return list;
    }
}
