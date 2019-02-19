package org.techrecipes.online.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.techrecipes.online.utilityfunctions.Timeit;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ParallelStreamIterationTest {
    @BeforeEach
    void setUp() {

    }

    @Test
    void compute() {
        Timeit.code(() -> System.out
                .println(IntStream.range(0, 1000).parallel().mapToDouble(i -> ParallelStreamIteration.computeSqrt())
                        .reduce(0, Double::sum)));
    }
}
