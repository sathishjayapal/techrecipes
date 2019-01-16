package org.techrecipes.online.high_orderfunction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class HighOrderFunctionTest {
    List<Integer> values;
    List<Person> people;
    List<String> stringList;
    @BeforeEach
    void setUp() {
        values = Arrays.asList(1, 2, 3, 5, 5);
        people = Arrays.asList(new Person("Jane", 42), new Person("Bob", 63),
                new Person("Kid1", 12), new Person("Kid2", 34));
        stringList = Arrays.asList("Sathish", "Family", "Is", "Needed");
    }

    @Test
    public void testHigherOrderFunction() {

        HighOrderFunction highOrderFunction = new HighOrderFunction();
        highOrderFunction.Iterate(values, System.out::println);
        values.forEach(highOrderFunction.createPrintIt());
        stringList.forEach(highOrderFunction.createPrintIt());
        people.stream().filter(person -> person.getAge() > 30).forEach(highOrderFunction.createPrintIt());
        highOrderFunction.printOnlySelectedPeople(people, highOrderFunction.checkForAge(30));
        highOrderFunction.printOnlySelectedPeople(people, highOrderFunction.checkForAge(40));
        highOrderFunction.printOnlySelectedPeople(people, highOrderFunction.checkForName.apply("J"));
        highOrderFunction.printOnlySelectedPeople(people, highOrderFunction.checkForName.apply("Y"));
    }

}