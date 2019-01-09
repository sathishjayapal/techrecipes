package org.techrecipes.online.behavior_pattern;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Created by sjayapal on 1/12/2017.
 */
@FunctionalInterface
public interface ApplePredicate {
    static List<Apple> filterApples(
            List<Apple> apples,
            ApplePredicate applePredicate) {
        List<Apple> result = apples.stream().filter(normalApple -> applePredicate.test(normalApple))
                .collect(Collectors.toList());
        return result;
    }
    boolean test(Apple apple);
}
