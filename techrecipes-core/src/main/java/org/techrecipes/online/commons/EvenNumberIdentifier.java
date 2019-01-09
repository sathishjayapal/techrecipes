package org.techrecipes.online.commons;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Created by sjayapal on 2/7/2017.
 */
public class EvenNumberIdentifier {
    public static boolean isEven(int number) {
        boolean isEvenNumber = false;
        if (number % 2 == 0) {
            isEvenNumber = true;
        }
        return isEvenNumber;
    }
    public static Stream divisibleByTwo(int inputNumber) {
        return Stream.iterate(inputNumber, e -> e + 1).filter(EvenNumberIdentifier::isEven);
    }
    public static void main(String args[]) {
        System.out.println(divisibleByTwo(2).limit(10).collect(Collectors.toList()));
    }
}
