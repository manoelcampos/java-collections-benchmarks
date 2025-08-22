package io.github.manoelcampos.benchmarks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Manoel Campos
 */
public class Util {
    public static final int LIST_SIZE = 1_000_000;
    public static final int MIDDLE = LIST_SIZE/2;
    public static final Supplier<List<String>> NEW_ARRAY_LIST_SUPPLIER = () -> new ArrayList<>(LIST_SIZE);

    private Util() {/**/}

    public static List<String> populateNewList(final Supplier<List<String>> emptyListCreator) {
        final var list = emptyListCreator.get();
        for (int i = 0; i < LIST_SIZE; i++) {
            list.add(Integer.toString(i));
        }
        return list;
    }
}
