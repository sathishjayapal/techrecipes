package org.techrecipes.online.strings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.techrecipes.online.springinjection.musicdomain.Music;

@Configuration("stringConfig")
@ComponentScan("org/techrecipes/online/strings")
public class StringConfig {
    @Autowired
    StringAtFunction stringAtFunction;

    @Bean(name = "stringAtFunction")
    public StringAtFunction createStringFunction() {
        return stringAtFunction;
    }
}
