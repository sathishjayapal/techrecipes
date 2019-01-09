package org.techrecipes.online.streams;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.techrecipes.online.utilityfunctions.Timeit;

/**
 * Created by sjayapal on 3/22/2017.
 */
@Component("streamFilterStream")
public class StreamsFilterSample {

  static final Logger LOG = LoggerFactory.getLogger(StreamsFilterSample.class);

  public void fakerFilterList() {
    List<Name> fakerList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      fakerList.add(new Faker().name());
    }
    fakerList.stream()
        .forEach(faker1 -> System.out.println("The faker gem is " + faker1.fullName()));
    fakerList.stream()
        .filter(fakerData -> (fakerData.fullName().startsWith("A") || fakerData.firstName()
            .startsWith("A"))).forEach(faker1 -> {
      System.out.println("The filter name is " + faker1.fullName());
    });
  }

  public void forEachSample() {
    List<String> names = Arrays.asList("Sara", "Sam", "Joe", "Jack", "Bill", "Joey");
    int total = 0;
    for (String name : names) {
      total += name.length();
    }
    System.out.println("The total len " + total);
    System.out.println(names.stream().filter(name -> name.startsWith("S")).
        map(name -> name.length()).reduce(0, Integer::sum));
  }

  public void lookUpPeek() {
    Stream.of("Sathish", "Jayapal").forEach(System.out::println);
    Stream.of(1, 2, 4, 5).forEach(System.out::println);
    int arr[] = {0, 9, 8, 7};
    System.out.println(
        "*******************************Wrong one*************************************");
    Stream.of(arr).forEach(System.out::println);
    System.out.println(
        "********************************Correct one ************************************");
    Arrays.stream(arr).peek(x -> System.out.println("From stream: " + x));
    Arrays.stream(arr).peek(x -> System.out.println("Here Stream " + x)).
        forEach(y -> System.out.println("Coming here :" + y));
  }

  public static void printNames(Stream<String> names, int length) {
    names.filter(name -> checkLength(name, length)).map(String::toUpperCase).
        forEach(System.out::println);
  }

  private static boolean checkLength(String name, int length) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return (name.length() == length);
  }

  public void streamForEachSample() {
    List<String> names = Arrays.asList("Sara", "Sam", "Joe", "Jack", "Bill", "Joey");
    Timeit.code(() -> printNames(names.stream(), 3));
    Timeit.code(() -> printNames(names.parallelStream(), 3));
  }

  public void streamGroupBy() {
    //3 apple, 2 banana, others 1
    List<Item> items = Arrays.asList(
        new Item(null, 10, new BigDecimal("20.00")),
        new Item("apple", 10, new BigDecimal("21.00")),
        new Item("apple", 10, new BigDecimal("22.00")),
        new Item("banana", 20, new BigDecimal("19.99")),
        new Item("orang", 10, new BigDecimal("29.99")),
        new Item("watermelon", 10, new BigDecimal("29.99")),
        new Item("papaya", 20, new BigDecimal("9.99")),
        new Item("apple", 10, new BigDecimal("9.99")),
        new Item("banana", 10, new BigDecimal("19.99")),
        new Item("apple", 20, new BigDecimal("9.99"))
    );
    //group by price
    Map<BigDecimal, List<Item>> groupByPriceMap =
        items.stream().collect(Collectors.groupingBy(Item::getPrice));
    Map<String, List<Item>> groupByNameMap =
        items.stream().filter(item -> item.getName() != null).collect(Collectors.groupingBy
            (Item::getName));
    System.out.println(groupByNameMap);
    // group by price, uses 'mapping' to convert List<Item> to Set<String>
    Map<BigDecimal, Set<String>> result =
        items.stream().collect(
            Collectors.groupingBy(
                Item::getPrice,
                Collectors.mapping(Item::getName, Collectors.toSet())
            )
        );
    System.out.println(result);
  }

  private static class Item {

    private String name;
    private int qty;
    private BigDecimal price;

    public Item(String name, int qty, BigDecimal price) {
      this.name = name;
      this.qty = qty;
      this.price = price;
    }

    public Item(String name, BigDecimal price) {
      this.name = name;
      this.price = price;
    }

    public int getQty() {
      return qty;
    }

    public void setQty(int qty) {
      this.qty = qty;
    }

    public BigDecimal getPrice() {
      return price;
    }

    public void setPrice(BigDecimal price) {
      this.price = price;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }

  private static List<String> setUpJig() {
    List<String> testStrings = new ArrayList<String>();
    testStrings.add("Blue");
    testStrings.add("Green");
    testStrings.add("Red");
    testStrings.add("CYAN");
    testStrings.add("Yellow");
    testStrings.add("Black");
    return testStrings;
  }

  private static void filterAndMap() {
    //simple sum all the numbers in the array
    System.out.println(IntStream.rangeClosed(1, 6).sum());
    //Simple state to add two numbers.
    System.out.println(
        "IntStream based on the sum of builders " + IntStream.builder().add(15).add(15)
            .build().sum());
    //MixedStr of string
    String mixedStr[] = {"a1", "a2", "a3"};
    Stream.of(mixedStr).map(x -> x.substring(1)).forEach(System.out::println);
//        setUpJig().stream().
  }

  private static void filterExtractMatchedString() {
    LOG.debug("");
    String compValue[] = {"B", "C"};
    System.out.println("The len is " + setUpJig().stream().sorted().peek(x ->
                                                                             System.out.println(
                                                                                 "x is " + x
                                                                                     .charAt(0)))
        .filter((s) ->
                    StringUtils.startsWith(s, "B")).count());
  }
}
