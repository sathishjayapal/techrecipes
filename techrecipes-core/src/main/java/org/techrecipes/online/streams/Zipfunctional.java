package org.techrecipes.online.streams;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
/**
 * Created by sathishjayapal on 7/18/16.
 */
public class Zipfunctional {
    public static void main(String args[]) {
        List<String> movies = Arrays.asList("Kabali", "Dum Dum Dum", "Zootopia");
        List<String> actors = Arrays.asList("Ragini", "Maddy", "Shakira");
        IntStream.range(0, Math.min(movies.size(), actors.size()))
                .mapToObj(i -> new String[]{movies.get(i), actors.get(i)})
                .forEach(pair -> System.out.println(pair[0] + "-----" + pair[1]));
    }
}
