package org.techrecipes.online.springwiring;
import javax.inject.Inject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan("org/techrecipes/online/springwiring")
public class SpringConfig {
  @Inject
  public Book returnBookObject() {
    return new Book();
  }
}
