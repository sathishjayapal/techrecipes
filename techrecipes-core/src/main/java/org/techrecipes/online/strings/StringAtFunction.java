package org.techrecipes.online.strings;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

@Component("stringAtFunction")
public class StringAtFunction {
    public String replaceStringWithStringBuffer() {
        String shortString = "I have a snitch in my team";
        Faker faker = new Faker();
        StringBuffer stringBuffer = new StringBuffer(shortString);
        stringBuffer.replace(0, 5, new StringBuffer().append(faker.name().fullName()).append("is a").toString());
        return stringBuffer.toString();
    }
}
