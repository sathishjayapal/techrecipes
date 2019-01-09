package org.techrecipes.online.streams;
import java.util.stream.IntStream;
/**
 * Created by sjayapal on 2/2/2017.
 */
public class RangeIterationSample {
    public static void main(String args[]) {
        //complex various reasons laid out.
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        IntStream.range(0, 5).forEach(i -> System.out.println("Range " + i));
        IntStream.rangeClosed(0, 5).forEach(i -> System.out.println("Range Closed " + i));
        IntStream.rangeClosed(0, 5).filter(e -> e % 2 == 0)
                .forEach(i -> System.out.println("Range Even " + i));
        IntStream.rangeClosed(0, 5).map(e -> e * 2)
                .forEach(i -> System.out.println("Double value " + i));
        IntStream.rangeClosed(0, 5).map(e -> e * 2).limit(3)
                .forEach(i -> System.out.println("Range value " + i));
    }
}
