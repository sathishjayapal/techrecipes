package org.techrecipes.online.lamma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org/techrecipes/online/lamma")
public class DateServiceConfig {
    @Autowired
    CalculateDateService calculateDateService;

}
