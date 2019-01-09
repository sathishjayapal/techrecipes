package org.techrecipes.online.behavior_pattern;
/**
 * Created by sjayapal on 2/8/2017.
 */
public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String opStr =
                "This is the best format to put the apple together " + apple.getWeight() + " and "
                        + apple.getColor();
        System.out.println(opStr);
        return opStr;
    }
}
