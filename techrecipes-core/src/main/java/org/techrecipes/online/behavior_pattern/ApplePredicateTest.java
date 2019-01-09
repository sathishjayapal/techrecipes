package org.techrecipes.online.behavior_pattern;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by sjayapal on 1/18/2017.
 */
public class ApplePredicateTest {
    static List<Apple> appleList = new ArrayList<Apple>();
    @BeforeClass
    public static void setUP() {
        Apple greenApple = new Apple();
        for (int i = 0; i < 100; i++) {
            greenApple.setColor(Apple.GREEN);
            int weight = RandomUtils.nextInt(100, 250);
            greenApple.setWeight(weight);
            appleList.add(greenApple);
        }
        Apple redApple = new Apple();
        for (int i = 0; i < 100; i++) {
            int weight = RandomUtils.nextInt(100, 250);
            if (weight > 100 && weight <= 200) {
                redApple.setColor(Apple.RED);
                redApple.setWeight(weight);
                appleList.add(redApple);
            }
        }
    }
    @Test
    public void testApplePredicate() {
        List<Apple> applePredicate = ApplePredicate
                .filterApples(appleList, new AppleGreenAndLightPredicate());
        Assert.assertTrue(applePredicate.size() > 0);
    }
    @Test
    public void testAppleFormatter() {
        List<Apple> redApplesPredicate = ApplePredicate
                .filterApples(appleList, new AppleRedAndHeavyPredicate());
        List<Apple> greenApplesPredicate = ApplePredicate
                .filterApples(appleList, new AppleGreenAndLightPredicate());
        redApplesPredicate.forEach(redApplesPredicateApple -> new AppleFancyFormatter()
                .accept(redApplesPredicateApple));
        greenApplesPredicate.forEach(greenApplesPredicateApple -> new AppleSimpleFormatter()
                .accept(greenApplesPredicateApple));
    }
}
