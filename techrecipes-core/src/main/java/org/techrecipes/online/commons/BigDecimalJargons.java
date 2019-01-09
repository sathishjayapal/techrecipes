package org.techrecipes.online.commons;
import java.math.BigDecimal;
/**
 * Created by sjayapal on 12/5/2016.
 */
public class BigDecimalJargons {
    public static void main(String args[]) {
        System.out.println((2.0 - 1.1) == .9);
        BigDecimal var1 = new BigDecimal(1.1);
        BigDecimal var2 = new BigDecimal(2.0);
        System.out.println(var2.subtract(var1) == BigDecimal.valueOf(.9));
    }
}
