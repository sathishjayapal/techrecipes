package org.techrecipes.online.references;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by sathishjayapal on 4/2/17.
 */
public class InternalversusExternalIterators {
    public static void main(String args[]) {
        List<Name> fakerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Faker faker = new Faker();
            fakerList.add(faker.name());
        }
        fakerList.forEach(faker -> System.out.println(faker.firstName()));
    }
}
