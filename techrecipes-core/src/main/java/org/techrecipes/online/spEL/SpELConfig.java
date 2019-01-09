package org.techrecipes.online.spEL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
@Configuration
@ComponentScan("org/techrecipes/online/spEL")
public class SpELConfig {
    @Bean
    public PropertiesFactoryBean spELProperties() {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("spEL.properties"));
        return bean;
    }
    @Value("#{ spELProperties['foo'] }")
    private String foo;
    public String getFoo() {
        return foo;
    }
}
