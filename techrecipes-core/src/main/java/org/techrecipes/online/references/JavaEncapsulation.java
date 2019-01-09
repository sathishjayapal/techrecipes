package org.techrecipes.online.references;
/**
 * Created by sathishjayapal on 6/2/16.
 * Java encapsulation, where the scope of encapsulation is at class level. The main method
 * cannot access the age directly. But an instance of it is allowing it.
 * Venkat's video link https://www.agilelearner.com/presentation/26
 */
public class JavaEncapsulation {
    private int age;
    public JavaEncapsulation(int age) {
        this.age = age;
    }
    public static void main(String args[]) {
        JavaEncapsulation encapsulation = new JavaEncapsulation(5);
        JavaEncapsulation encapsulation1 = new JavaEncapsulation(6);
        encapsulation.amPlayingwith(encapsulation1);
    }
    public void amPlayingwith(JavaEncapsulation ipage) {
        System.out.println("I am of age " + this.age + " playing with " + ipage.age);
    }
}
