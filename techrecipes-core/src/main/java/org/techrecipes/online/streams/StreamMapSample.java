package org.techrecipes.online.streams;
import com.github.javafaker.Faker;
import java.util.Arrays;
import java.util.stream.IntStream;
public class StreamMapSample {
  public static void main(String args[]) {
    Faker faker = new Faker();
    System.out
        .println(Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(e -> e * 2).reduce(0, Integer::sum));
    System.out.println(
        Arrays.asList(1, 2, 3, 4, 5, 6).stream().mapToInt(w -> w * 2).reduce(Integer::sum));
    String names[] = {faker.name().fullName(), "Shawn", faker.name().fullName(),
        faker.name().fullName()};
    int intAwesomeArray[] = IntStream.range(1, 200000).unordered().filter(data -> data % 2 == 0)
        .toArray();
    System.out.println(Arrays.binarySearch(names, "Sathish"));
  }
}
