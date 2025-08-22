package io.github.manoelcampos.benchmarks;

import java.io.IOException;

/**
 * Starts all benchmarks defined in this project.
 * @author Manoel Campos
 */
public class Runner {
    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }
}
