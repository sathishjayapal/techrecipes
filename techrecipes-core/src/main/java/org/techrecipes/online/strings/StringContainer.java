package org.techrecipes.online.strings;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.github.javafaker.Name;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringContainer {
    private static Map<String, String> fakeObjectContainer = new HashMap();
    private static List<String> idList= new ArrayList<>();
    public static void main(String args[]) {
        System.out.println("Manipulation starting");
        String stringWithPrefix = "stringWithPrefix";
        for (int i = 0; i < 2000000; i++) {
            Faker startFaker= new Faker();
            Name fakeName= startFaker.name();
            IdNumber idNumber= startFaker.idNumber();
            fakeObjectContainer.put(idNumber.valid(),fakeName.fullName());
            idList.add(idNumber.valid());
        }
        System.out.println("Map size: " + fakeObjectContainer.size());
        System.gc();
        for (int i = 0; i < 1000000; i++) {
            String newString = stringWithPrefix + i;
            fakeObjectContainer.remove(idList.get(i));
        }
        System.out.println("New Map size is :" + fakeObjectContainer.size());
        System.out.println("End of Manipulation");
    }
}
