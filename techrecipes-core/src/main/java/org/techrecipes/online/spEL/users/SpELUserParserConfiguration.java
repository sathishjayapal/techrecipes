package org.techrecipes.online.spEL.users;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * Created by sjayapal on 11/28/2017.
 */
@Configuration
@ComponentScan("spEL.users")
public class SpELUserParserConfiguration {
  public List<SpELUser> spELUsers;
  @Bean
  public String identifier(@Value("${occupation:Programmer}") String occupation) {
    return occupation;
  }
  @Bean(name = "spelUser")
  @Value("#{occupation}")
  public SpELUser createSpELUser() {
    SpELUser music = new SpELUser();
    return music;
  }
}
