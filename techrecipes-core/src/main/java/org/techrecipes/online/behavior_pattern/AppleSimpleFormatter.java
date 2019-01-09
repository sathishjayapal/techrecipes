package org.techrecipes.online.behavior_pattern;
/**
 * Created by sjayapal on 2/8/2017.
 */
public class AppleSimpleFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String anotherStr = "This is a simple format Apple " + apple.getWeight();
        System.out.println(anotherStr);
        return anotherStr;
    }
}
