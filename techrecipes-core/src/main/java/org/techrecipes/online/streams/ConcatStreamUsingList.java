package org.techrecipes.online.streams;
import com.github.javafaker.Faker;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.techrecipes.online.references.DataFiller;

/**
 * Created by sathishjayapal on 7/18/16.
 */
public class ConcatStreamUsingList extends DataFiller {
  public static void main(String args[]) {
    ConcatStreamUsingList concatStreamUsingList = new ConcatStreamUsingList();
    Faker nameFaker = new Faker();
    String[] namesFromFirstBatch = {nameFaker.name().fullName(), nameFaker.name().fullName(),
        nameFaker.name()
            .fullName(), nameFaker.name().fullName()};
    String[] namesFromSecondBatch = {nameFaker.name().fullName(), nameFaker.name().fullName(),
        nameFaker.name()
            .fullName(), nameFaker.name().fullName()};
    List<String> nameList = Arrays.asList(namesFromFirstBatch);
    System.out.println("The first Stream is ");
    nameList.stream().sorted(String::compareToIgnoreCase).forEach(s -> System.out
        .println(s));
    System.out.println("End of the first Stream");
    List<String> secondList = Arrays.asList(namesFromSecondBatch);
    System.out.println("The second Stream is ");
    secondList.stream().sorted(String::compareToIgnoreCase).forEach(s -> System.out
        .println(s));
    System.out.println("End of the second Stream");
    List<String> finalStream = Stream.concat(nameList.stream(), secondList.stream())
        .sorted(String::compareToIgnoreCase)
        .collect(
            Collectors.toList());
    System.out.println("The final Stream is ");
    finalStream.stream().sorted().forEach(s -> System.out
        .println(s));
    System.out.println("End of the final Stream");
    IntStream randomInt = new Random().ints();
    randomInt.peek(value ->
                       System.out.println("Coming in with the value " + value)).
        filter(value -> value > 0 && value % 2 == 0)
        .limit(10)
        .forEach(value -> System.out.println("The value that we "
                                                 + "need is here "
                                                 + value));
  }
}
