package org.techrecipes.online.references;

import java.text.StringCharacterIterator;

/**
 * Created by sathishjayapal on 5/27/16.
 */
public class StringCharacterIteratorSample {
    public static void main(String args[]) {
        String hello = "Hello world";
        StringCharacterIterator stringCharIterator = new StringCharacterIterator(hello);
        System.out.println(stringCharIterator.first());
        System.out.println(stringCharIterator.getEndIndex());
    }
}
