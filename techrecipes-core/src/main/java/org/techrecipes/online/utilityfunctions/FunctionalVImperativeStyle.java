package org.techrecipes.online.utilityfunctions;
import java.util.Arrays;
import java.util.List;
/**
 * Created by sjayapal on 3/3/2017.
 */
public class FunctionalVImperativeStyle {
    public static void main(String args[]) {
        List<String> namesData = Arrays.asList("Ali", "Moahmmed", "Feroze", "Syed");
        //Imperative Style program to find Syed
        for (String name : namesData) {
            if (name.equalsIgnoreCase("Syed")) {
                System.out.println("Found Name");
            }
        }
        //Declarative style program to find Syed
        if (namesData.contains("Syed")) {
            System.out.println("Found Declarative style");
        }
    }
}
