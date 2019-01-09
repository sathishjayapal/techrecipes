package org.techrecipes.online.performancesapi;
import org.techrecipes.online.utilityfunctions.Timeit;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
/**
 * Created by sjayapal on 2/21/2017.
 */
public class AutoBoxPerformanceBenchMarker {
    static IntPredicate evenNumbers = (int i) -> i % 2 == 0;
    static Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;
    public static void functionEven() {
        Integer runningVar = new Integer(1000);
        for (int i = 0; i < runningVar; i++) {
            if (i % 2 == 0) {
                System.out.println("Even");
            }
        }
    }
    public static void main(String args[]) {
        Timeit.code(() -> evenNumbers.test(1000));
        Timeit.code(() -> oddNumbers.test(1000));
        Timeit.code(() -> functionEven());
    }
}
