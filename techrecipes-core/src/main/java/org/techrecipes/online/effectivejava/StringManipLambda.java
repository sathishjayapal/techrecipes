package org.techrecipes.online.effectivejava;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringManipLambda {
    public static void main(String args[]){
        List<String> stringArras= Arrays.asList("First","Second","third","fourth","fifth");
        Collections.sort(stringArras,(s1,s2)->Integer.compare(s1.length(),s2.length()));
        stringArras.stream().forEach(System.out::println);

    }
}
