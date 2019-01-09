package org.techrecipes.online.references;
import java.util.Arrays;
import java.util.List;
/**
 * Created by sjayapal on 3/3/2017.
 */
public class FunctionVersusMethodSample {
    public static void staticMemberMethod() {
        System.out.println("This is a static member method");
    }
    public static void main(String args[]) {
        FunctionVersusMethodSample functionVersusMethodSample = new FunctionVersusMethodSample();
        functionVersusMethodSample.memberMethod();
        FunctionVersusMethodSample.staticMemberMethod();
        List<String> stringList = Arrays.asList("Sathish", "Jayapal");
        stringList.forEach(System.out::println);
    }
    public void memberMethod() {
        System.out.println("This is a member method");
    }
}
