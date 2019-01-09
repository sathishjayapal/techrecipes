package org.techrecipes.online.streams;
import org.techrecipes.online.utilityfunctions.Timeit;
import java.util.Arrays;
/**
 * Created by sjayapal on 2/9/2017.
 */
public class ForEachSamplers {
    public static void main(String args[]) {
        Timeit.code(() -> {
            for (char c : "Sathish".toCharArray()) {
                System.out.println(c);
            }
        });
        Timeit.code(
                () -> Arrays.asList("Sathish".toCharArray()).forEach((c) -> System.out.println(c)));
        String str = "Test this";
    }
}

