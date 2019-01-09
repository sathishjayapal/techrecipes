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
    static Function<String, Predicate<Person>> checkForName = name -> person -> person.getName()
            .startsWith("K");
    public static void main(String args[]) {
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 5);
        List<Person> people = Arrays.asList(new Person("Jane", 42), new Person("Bob", 63),
                new Person("Kid1", 12), new Person("Kid2", 34));
        List<String> stringList = Arrays.asList("Sathish", "Family", "Is", "Needed");
        Iterate(values, System.out::println);
        values.forEach(createPrintIt());
        stringList.forEach(createPrintIt());
        people.stream().filter(person -> person.getAge() > 30).forEach(createPrintIt());
        printOnlySelectedPeople(people, checkForAge(30));
        printOnlySelectedPeople(people, checkForAge(40));
        printOnlySelectedPeople(people, checkForName.apply("K"));
        printOnlySelectedPeople(people, checkForName.apply("Y"));
    }
    /**
     * This is a sample for using the Values of calling function within.
     */
    private static void Iterate(List<Integer> values, Consumer<Integer> printIt) {
        values.forEach(printIt);
    }
    /**
     * Code to reuse the print function data
     */
    private static <T> Consumer<T> createPrintIt() {
        return System.out::println;
    }
    /**
     * This is an sample for the predicate information.
     */
    private static void printOnlySelectedPeople(List<Person> people, Predicate<Person> selector) {
        System.out.println("-----------------------------");
        people.stream().filter(selector).forEach(System.out::println);
    }
    private static Predicate<Person> checkForAge(int age) {
        Predicate<Person> checkPred = person -> person.getAge() > age;
        return checkPred;
    }
}
