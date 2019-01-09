package org.techrecipes.online.commons;
import java.util.HashSet;
import java.util.Set;
/**
 * Created by sjayapal on 5/15/2017.
 */
public class JavaQuiz {
    public static void main(String args[]) {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("");
        stringSet.add(null);
        try {
            stringSet.removeIf(String::isEmpty);
        } catch (Throwable t) {
            System.out.println("Something went wrong");
        }
    }
}
