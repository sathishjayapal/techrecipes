package org.techrecipes.online.commons;
import java.util.Arrays;
import java.util.List;
/**
 * Created by sjayapal on 2/2/2017.
 */
public class SortingSample {
    public static void main(String args[]) {
        List<Person> folks = Arrays
                .asList(new Person("Sam", 2), new Person("Jane", 3), new Person("Kim", 1));
        folks.stream().sorted((person1, person2)
                -> person1.compareAge(person2)).forEach(System.out::println);
        folks.stream().sorted(Person::compareAge).forEach(System.out::println);
        folks.stream().sorted((person1, person2)
                -> Person.whoSOld(person1, person2)).forEach(System.out::println);
        folks.stream().sorted(Person::whoSOld).forEach(System.out::println);
    }
}
class Person {
    public final String name;
    public final int age;
    Person(String name, int theAge) {
        this.name = name;
        this.age = theAge;
    }
    public static int whoSOld(Person p1, Person p2) {
        return p1.age - p2.age;
    }
    public int compareAge(Person other) {
        return age - other.age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
