package org.techrecipes.online.high_orderfunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by sjayapal on 2/10/2017.
 */
public class HighOrderFunction {
    /**
     * This is an sample for the Lexical scope sample
     */
    public Function<String, Predicate<Person>> checkForName = name -> person -> person.getName()
            .startsWith("K");

    /**
     * This is a sample for using the Values of calling function within.
     */
    public static void Iterate(List<Integer> values, Consumer<Integer> printIt) {
        values.forEach(printIt);
    }

    /**
     * Code to reuse the print function data
     */
    public static <T> Consumer<T> createPrintIt() {
        return System.out::println;
    }

    /**
     * This is an sample for the predicate information.
     */
    public static void printOnlySelectedPeople(List<Person> people, Predicate<Person> selector) {
        System.out.println("-----------------------------");
        people.stream().filter(selector).forEach(System.out::println);
    }

    public static Predicate<Person> checkForAge(int age) {
        Predicate<Person> checkPred = person -> person.getAge() > age;
        return checkPred;
    }
}
