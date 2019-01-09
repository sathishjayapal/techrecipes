package org.techrecipes.online.commons;
/**
 * Created by sjayapal on 12/5/2016.
 */
public class Util {
    public static boolean even(int i) {
        return i % 2 == 0;
    }
    public static boolean odd(int i) {
        return !even(i);
    }
}
