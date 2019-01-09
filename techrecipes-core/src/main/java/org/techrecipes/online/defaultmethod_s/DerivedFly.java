package org.techrecipes.online.defaultmethod_s;
/**
 * Created by sathishjayapal on 5/14/16.
 */
public interface DerivedFly extends Fly {
    default void SimpleFly() {
        System.out.println("Derived Interface Fly");
    }
}
