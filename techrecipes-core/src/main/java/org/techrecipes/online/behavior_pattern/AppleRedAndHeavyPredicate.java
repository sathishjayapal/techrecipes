package org.techrecipes.online.behavior_pattern;
/**
 * Created by sjayapal on 1/12/2017.
 */
public class AppleRedAndHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().
                equalsIgnoreCase(Apple.RED)
                && apple.getWeight() > 150;
    }
}
