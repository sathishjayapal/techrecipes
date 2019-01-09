package org.techrecipes.online.strings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

@Configuration("stringTestConfig")
@ComponentScan("org/techrecipes/online/strings")
public class StringTestConfig {
    @Autowired
    StringAtFunction stringAtFunction;

    public StringAtFunction createStringFunction() {
        return stringAtFunction;
    }

}
