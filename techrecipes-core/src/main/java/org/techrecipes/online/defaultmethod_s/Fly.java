package org.techrecipes.online.defaultmethod_s;
/**
 * Created by sathishjayapal on 5/14/16.
 */
public interface Fly {
    default void SimpleFly() {
        System.out.println("Inside Interface Fly");
    }
}
