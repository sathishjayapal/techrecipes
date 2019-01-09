package org.techrecipes.online.references;
import com.sun.org.apache.regexp.internal.StringCharacterIterator;
/**
 * Created by sathishjayapal on 5/27/16.
 */
public class StringCharacterIteratorSample {
    public static void main(String args[]) {
        String hello = "Hello world";
        StringCharacterIterator stringCharIterator = new StringCharacterIterator(hello);
        System.out.println(stringCharIterator.charAt(0));
        System.out.println(stringCharIterator.isEnd(5));
//        stringCharIterator::charAt;
    }
}
