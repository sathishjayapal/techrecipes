package org.techrecipes.online.streams;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
public class StreamGenerateSample {
  public static void printSize(Stream<Integer> stream) {
    out.println(stream.count());
  }
  public static <T> void printStream(Stream<T> stream) {
    stream.limit(10).forEach(System.out::println);
  }
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 5);
    printSize(numbers.stream());
    Random random = new Random();
    out.println("Output value for variable random = " + random.nextInt());
    Stream<Integer> stream = Stream.generate(() -> random.nextInt());
    stream.limit(5).forEach(System.out::println);
    printStream(random.ints().boxed());
  }
}
