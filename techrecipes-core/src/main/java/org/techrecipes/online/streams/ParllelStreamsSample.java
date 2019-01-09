package org.techrecipes.online.streams;
import org.techrecipes.online.utilityfunctions.Timeit;
import java.util.stream.IntStream;
/**
 * Created by sjayapal on 4/25/2017.
 */
public class ParllelStreamsSample {
    final static long MAX = 50000000;
    public static double compute() {
        double result = 0;
        for (int i = 0; i < MAX; i++) {
            result += Math.sqrt(i);
        }
        return result;
    }
    public static void main(String args[]) {
        Timeit.code(() -> System.out
                .println(IntStream.range(0, 1000).parallel().mapToDouble(i -> compute())
                        .reduce(0, Double::sum)));
    }
}
